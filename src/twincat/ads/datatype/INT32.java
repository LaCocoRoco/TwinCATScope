package twincat.ads.datatype;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import twincat.ads.Ads;
import twincat.ads.AdsException;
import twincat.ads.enums.AdsError;
import twincat.ads.enums.DataType;
import twincat.ads.wrapper.Variable;

public class INT32 extends Variable {
	/*************************/
	/****** constructor ******/
	/*************************/

	public INT32(Ads ads, int symbolHandle) {
		super(ads, DataType.INT32.size, symbolHandle);
	}

	public INT32(Ads ads, int indexGroup, int indexOffset) throws AdsException {
		super(ads, DataType.INT32.size, indexGroup, indexOffset);
	}
	
	public INT32(Ads ads, String symbolName) throws AdsException {
		super(ads, DataType.INT32.size, ads.readHandleOfSymbolName(symbolName));
	}
	
	/*************************/
	/******** override *******/
	/*************************/

	@Override
	public DataType getDataType() {
		return DataType.INT32;
	}

	@Override
	public boolean toBoolean() {
		return INT32.arrayToValue(data) > 0 ? true : false;
	}

	@Override
	public byte toByte() {
		return (byte) INT32.arrayToValue(data);
	}

	@Override
	public short toShort() {
		return (short) INT32.arrayToValue(data);
	}

	@Override
	public int toInteger() {
		return (int) INT32.arrayToValue(data);
	}

	@Override
	public long toLong() {
		return (long) INT32.arrayToValue(data);
	}

	@Override
	public float toFloat() {
		return (float) INT32.arrayToValue(data);
	}

	@Override
	public double toDouble() {
		return (double) INT32.arrayToValue(data);
	}

	@Override
	public String toString() {
		return Integer.toString(INT32.arrayToValue(data));
	}

	@Override
	public Variable write(boolean value) throws AdsException {
		int data = value ? (int) 1 : (int) 0;
		super.write(INT32.valueToArray(data));
		return this;
	}

	@Override
	public Variable write(byte value) throws AdsException {
		super.write(INT32.valueToArray((int) value));
		return this;
	}

	@Override
	public Variable write(short value) throws AdsException {
		super.write(INT32.valueToArray((int) value));
		return this;
	}

	@Override
	public Variable write(int value) throws AdsException {
		super.write(INT32.valueToArray((int) value));
		return this;
	}

	@Override
	public Variable write(long value) throws AdsException {
		super.write(INT32.valueToArray((int) value));
		return this;
	}

	@Override
	public Variable write(float value) throws AdsException {
		super.write(INT32.valueToArray((int) value));
		return this;
	}

	@Override
	public Variable write(double value) throws AdsException {
		super.write(INT32.valueToArray((int) value));
		return this;
	}

	@Override
	public Variable write(String value) throws AdsException {
		try  {
			int data = Integer.parseInt(value);
			super.write(INT32.valueToArray(data));
		} catch(NumberFormatException e) {
			throw new AdsException(AdsError.ADS_WRITE_PARSE_ERROR);
		}
		return this;
	}

	/*************************/
	/** public static final **/
	/*************************/

	public static final int arrayToValue(byte[] data) {
		if (data.length != DataType.INT32.size) return 0;
		ByteBuffer byteBuffer = ByteBuffer.wrap(data);
		byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
		return byteBuffer.getInt();
	}

	public static final byte[] valueToArray(int data) {
		byte[] buffer = new byte[Integer.BYTES];
		ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);
		byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
		byteBuffer.putInt(data);
		return buffer;
	}
}