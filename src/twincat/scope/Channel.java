package twincat.scope;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import twincat.ads.Ads;
import twincat.ads.AdsException;
import twincat.ads.wrapper.Variable;

public class Channel extends Observable implements Observer {
	/*************************/
	/** constant attributes **/
	/*************************/		
	
	private static final int NOTIFICATION_TIMEOUT = 200;
	
	private static final int WATCHDOG_TIMEOUT = 2000;

	/*************************/
	/*** global attributes ***/
	/*************************/

	private boolean refresh = false;

	private String channelName = "Channel";

	private boolean channelVisible = true;

	private boolean antialias = false;

	private Color lineColor = Color.RED;

	private int lineWidth = 1;

	private boolean lineVisible = true;

	private Color plotColor = Color.RED;

	private int plotSize = 4;

	private boolean plotVisible = true;

	private boolean watchdogEnabled = false;

	private String channelError = new String();

	private int notificationError = 0;

	private final Samples samples = new Samples();

	/*************************/
	/*** local attributes ***/
	/*************************/
	
	private Acquisition acquisition = null;

	private boolean notificationStarted = false;

	private boolean watchdogStarted = false;	

	private long notificationTimeout = 0;

	private long watchdogTimeout = 0;

	private Ads ads = new Ads();
	
	private Variable variable = null;

	private ScheduledFuture<?> schedule = null;

	private Runnable task = new Runnable() {
		public void run() {
			watchdog();
		}
	};

	/*************************/
	/****** constructor ******/
	/*************************/

	public Channel(Acquisition acquisition) {
		this.acquisition = acquisition;
	}

	/*************************/
	/**** setter & getter ****/
	/*************************/
	
	public boolean isRefresh() {
		return refresh;
	}

	public void setRefresh(boolean refresh) {
		this.refresh = refresh;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
		this.refresh = true;
	}

	public boolean isAntialias() {
		return antialias;
	}

	public void setAntialias(boolean antialias) {
		this.antialias = antialias;
		this.refresh = true;
	}

	public boolean isChannelVisible() {
		return channelVisible;
	}

	public void setChannelVisible(boolean channelVisible) {
		this.channelVisible = channelVisible;
		this.refresh = true;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
		this.refresh = true;
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
		this.refresh = true;
	}

	public boolean isLineVisible() {
		return lineVisible;
	}

	public void setLineVisible(boolean lineVisible) {
		this.lineVisible = lineVisible;
		this.refresh = true;
	}

	public Color getPlotColor() {
		return plotColor;
	}

	public void setPlotColor(Color plotColor) {
		this.plotColor = plotColor;
		this.refresh = true;
	}

	public int getPlotSize() {
		return plotSize;
	}

	public void setPlotSize(int plotSize) {
		this.plotSize = plotSize;
		this.refresh = true;
	}

	public boolean isPlotVisible() {
		return plotVisible;
	}

	public void setPlotVisible(boolean plotVisible) {
		this.plotVisible = plotVisible;
		this.refresh = true;
	}

	public boolean isWatchdogEnabled() {
		return watchdogEnabled;
	}

	public void setWatchdogEnabled(boolean watchdogEnabled) {
		this.watchdogEnabled = watchdogEnabled;
		this.refresh = true;
	}
	
	public String getChannelError() {
		return channelError;
	}

	public void setChannelError(String channelError) {
		this.channelError = channelError;
		this.refresh = true;
	}

	public int getNotificationError() {
		return notificationError;
	}

	public void setNotificationError(int notificationError) {
		this.notificationError = notificationError;
		this.refresh = true;
	}

	public Samples getSamples() {
		return samples;
	}

	/*************************/
	/********* public ********/
	/*************************/

	@Override
	public void update(Observable observable, Object object) {
		samples.add(variable.toDouble(), variable.getTimeStamp());
		notificationTimeout = System.currentTimeMillis();
		setChanged();
		notifyObservers();
	}	

	public void start() {
		startChannel();
		startNotification();
		startWatchdog();
	}

	public void stop() {
		stopNotification();
		stopWatchdog();
	}

	public void close() {
		stopNotification();
		stopWatchdog();
	}
	
	/*************************/
	/******** private ********/
	/*************************/	

	private void startNotification() {
		if (!notificationStarted) {
			notificationStarted = true;
			
			ads.setAmsNetId(acquisition.getAmsNetId());
			ads.setAmsPort(acquisition.getAmsPort());
			ads.open();
			
			try {
				if (acquisition.isSymbolBased()) {
					variable = ads.getVariableBySymbolName(acquisition.getSymbolName());
					variable.addObserver(this);
					variable.addNotification(acquisition.getTaskTime());
				} else {
					variable = ads.getVariableByAddress(acquisition.getDataType(),
							acquisition.getIndexGroup(), acquisition.getIndexOffset());
					variable.addObserver(this);
					variable.addNotification(acquisition.getTaskTime());
				}
			} catch (AdsException adsException) {
				channelError = "Notification Start | " + adsException.getAdsErrorMessage();
				notificationStarted = false;
				stopWatchdog();
			}	
		}	
	}

	private void stopNotification() {
		if (notificationStarted) {
			notificationStarted = false;
			
			try {
				variable.close();
			} catch (AdsException adsException) {
				channelError = "Notification Stop | " + adsException.getAdsErrorMessage();
			}
		}
	}
	
	private void stopWatchdog() {
		if (watchdogStarted) {
			watchdogStarted = false;
			Scope.stopSchedule(schedule);	
		}
	}
	
	private void startWatchdog() {
		if (!watchdogStarted && watchdogEnabled && notificationStarted) {
			watchdogStarted = true;
			watchdogTimeout = System.currentTimeMillis();
			notificationTimeout = System.currentTimeMillis();
			notificationError = 0;
			ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
			schedule = scheduler.scheduleAtFixedRate(task, 0, NOTIFICATION_TIMEOUT, TimeUnit.MILLISECONDS);
		}
	}
	
	private void watchdog() {
		if (System.currentTimeMillis() - watchdogTimeout > WATCHDOG_TIMEOUT) {
			stopNotification();
			stopWatchdog();
			channelError = "Watchdog Timeout";
			return;
		}
		
		if (System.currentTimeMillis() - notificationTimeout > NOTIFICATION_TIMEOUT) {
			notificationError++;
			stopNotification();
			startNotification();
			return;
		}
		
		watchdogTimeout = System.currentTimeMillis();
	}

	private void startChannel() {
		samples.clear();
		channelError = "None";
	}
}