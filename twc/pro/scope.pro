CoDeSys+%                      @        @   2.3.9.59    @/    @                             BДa +    @      ЭЭЭЭЭЭЭЭ             P
bC        0   @   q   C:\TWINCAT\PLC\LIB\STANDARD.LIB @                                                                                          CONCAT               STR1               §џ              STR2               §џ                 CONCAT                                         Фн66     џџџџ           CTD           M             §џ           Variable for CD Edge Detection      CD            §џ           Count Down on rising edge    LOAD            §џ           Load Start Value    PV           §џ           Start Value       Q            §џ           Counter reached 0    CV           §џ           Current Counter Value             Фн66     џџџџ           CTU           M             §џ            Variable for CU Edge Detection       CU            §џ       
    Count Up    RESET            §џ           Reset Counter to 0    PV           §џ           Counter Limit       Q            §џ           Counter reached the Limit    CV           §џ           Current Counter Value             Фн66     џџџџ           CTUD           MU             §џ            Variable for CU Edge Detection    MD             §џ            Variable for CD Edge Detection       CU            §џ	       
    Count Up    CD            §џ
           Count Down    RESET            §џ           Reset Counter to Null    LOAD            §џ           Load Start Value    PV           §џ           Start Value / Counter Limit       QU            §џ           Counter reached Limit    QD            §џ           Counter reached Null    CV           §џ           Current Counter Value             Фн66     џџџџ           DELETE               STR               §џ              LEN           §џ              POS           §џ                 DELETE                                         Фн66     џџџџ           F_TRIG           M             §џ
                 CLK            §џ           Signal to detect       Q            §џ           Edge detected             Фн66     џџџџ           FIND               STR1               §џ              STR2               §џ                 FIND                                     Фн66     џџџџ           INSERT               STR1               §џ              STR2               §џ              POS           §џ                 INSERT                                         Фн66     џџџџ           LEFT               STR               §џ              SIZE           §џ                 LEFT                                         Фн66     џџџџ           LEN               STR               §џ                 LEN                                     Фн66     џџџџ           MID               STR               §џ              LEN           §џ              POS           §џ                 MID                                         Фн66     џџџџ           R_TRIG           M             §џ
                 CLK            §џ           Signal to detect       Q            §џ           Edge detected             Фн66     џџџџ           REPLACE               STR1               §џ              STR2               §џ              L           §џ              P           §џ                 REPLACE                                         Фн66     џџџџ           RIGHT               STR               §џ              SIZE           §џ                 RIGHT                                         Фн66     џџџџ           RS               SET            §џ              RESET1            §џ                 Q1            §џ
                       Фн66     џџџџ           SEMA           X             §џ                 CLAIM            §џ	              RELEASE            §џ
                 BUSY            §џ                       Фн66     џџџџ           SR               SET1            §џ              RESET            §џ                 Q1            §џ	                       Фн66     џџџџ           TOF           M             §џ           internal variable 	   StartTime            §џ           internal variable       IN            §џ       ?    starts timer with falling edge, resets timer with rising edge    PT           §џ           time to pass, before Q is set       Q            §џ	       2    is FALSE, PT seconds after IN had a falling edge    ET           §џ
           elapsed time             Фн66     џџџџ           TON           M             §џ           internal variable 	   StartTime            §џ           internal variable       IN            §џ       ?    starts timer with rising edge, resets timer with falling edge    PT           §џ           time to pass, before Q is set       Q            §џ	       0    is TRUE, PT seconds after IN had a rising edge    ET           §џ
           elapsed time             Фн66     џџџџ           TP        	   StartTime            §џ           internal variable       IN            §џ       !    Trigger for Start of the Signal    PT           §џ       '    The length of the High-Signal in 10ms       Q            §џ	           The pulse    ET           §џ
       &    The current phase of the High-Signal             Фн66     џџџџ    R    @                                                                                          FB_AXIS_SIMULATOR           l_ton_timer                    TON    $            
   l_b_impuls             $               l_b_direction             $               
   l_t_impuls           $            	   i_i_range           $ 	              i_lr_min                        $ 
              i_lr_max                        $                      io_lr_value                        $                    	лй`  @    џџџџ           MAIN           fb_channel_set_pos                      fb_axis_simulator                 
   di_set_pos                         
   lr_set_pos                                      plc    fb_channel_1                      fb_axis_simulator      
              fb_channel_2                      fb_axis_simulator                    fb_channel_3                      fb_axis_simulator                    fb_channel_4                      fb_axis_simulator                    fb_channel_5                      fb_axis_simulator                    fb_channel_6                      fb_axis_simulator                    fb_channel_7                      fb_axis_simulator                    fb_channel_8                      fb_axis_simulator                    lr_channel_1                                         lr_channel_2                                         lr_channel_3                                         lr_channel_4                                         lr_channel_5                                         lr_channel_6                                         lr_channel_7                                         lr_channel_8                                                          BДa  @  џџџџ            
 Ъ      $          (       K   -     K   ;     K   I     K   ^                 k         +     КЛlocalhost A     3ЋТw8#Т A                hО         м А>Уw0 Сwџџџџ3ЋТw0#Т    ќ  A         0#ТxО            DдЯ                 Yљ b9Р   eЭж 8#Т  Ой єл ил №њwxѕwџџџџ:ѕwќ  A        ќ  A     Рн DдЯ Рн  м DдЯ а'џџџџЌм 1Я     ,   ,                                                        K        @   	лй`@   /*BECKCONFI3*/
        !РЈJ @   @           3                  Standard            	CДa                        VAR_GLOBAL
END_VAR
                                                                                  "   ,   И             Standard         MAINџџџџ               BДa                 $ћџџџ                         Pч р<А           Standard iчj@	iчj@      @+р+ м0ѕ                         	BДa                        VAR_CONFIG
END_VAR
                                                                                   '              , 4 4 Є           Global_Variables 	лй`		лй`                        VAR_GLOBAL
END_VAR
                                                                                               '                                   TwinCAT_Configuration +лй`	BДa                     m   (* Generated automatically by TwinCAT - (read only) *)
VAR_CONFIG
	MAIN.di_set_pos AT %QB0 : DINT;
END_VAR                                                                                               '           	                        Variable_Configuration 	лй`		лй`	                        VAR_CONFIG
END_VAR
                                                                                                 Q   |0|0 @G    @%   MS Sans Serif @        @           ѓџџџ                               џ      џ   џџџ  Ь3 џџџ   џ џџџ     
    @џ  џџџ     @      DEFAULT             System      Q   |0|0 @G    @%   MS Sans Serif @        @           ѓџџџ                      )   hh':'mm':'ss @                             dd'-'MM'-'yyyy @       '     $   , h h Э           fb_axis_simulator 	лй`		лй`                      	  FUNCTION_BLOCK fb_axis_simulator

VAR_IN_OUT
	io_lr_value		:LREAL;
END_VAR

VAR_INPUT
	l_t_impuls		:TIME;
	i_i_range			:INT;
	i_lr_min			:LREAL;
	i_lr_max			:LREAL;
END_VAR

VAR
	l_ton_timer		:TON;
	l_b_impuls		:BOOL;
	l_b_direction		:BOOL;
END_VARЅ  l_ton_timer( PT := l_t_impuls );

IF l_ton_timer.Q THEN
	l_ton_timer.IN := FALSE;
ELSE
	l_ton_timer.IN := TRUE;
END_IF

IF io_lr_value > i_lr_max THEN
	l_b_direction := TRUE;
END_IF

IF io_lr_value < i_lr_min THEN
	l_b_direction := FALSE;
END_IF

IF  l_ton_timer.Q THEN
	IF l_b_direction THEN
		io_lr_value := io_lr_value - i_i_range;
	ELSE
		io_lr_value := io_lr_value + i_i_range;
	END_IF
END_IF
                   ,     гБ           MAIN BДa	BДa                        PROGRAM MAIN
VAR
	(* nc *)
	fb_channel_set_pos	:fb_axis_simulator;

	di_set_pos			AT%Q*	:DINT;
	lr_set_pos					:LREAL;

	(* plc *)
	fb_channel_1			:fb_axis_simulator;
	fb_channel_2			:fb_axis_simulator;
	fb_channel_3			:fb_axis_simulator;
	fb_channel_4			:fb_axis_simulator;
	fb_channel_5			:fb_axis_simulator;
	fb_channel_6			:fb_axis_simulator;
	fb_channel_7			:fb_axis_simulator;
	fb_channel_8			:fb_axis_simulator;

	lr_channel_1			:LREAL;
	lr_channel_2			:LREAL;
	lr_channel_3			:LREAL;
	lr_channel_4			:LREAL;
	lr_channel_5			:LREAL;
	lr_channel_6			:LREAL;
	lr_channel_7			:LREAL;
	lr_channel_8			:LREAL;
END_VARд  (* nc *)
fb_channel_set_pos(
	l_t_impuls	:= t#1ms,
	i_i_range		:= 10000,
	i_lr_min		:= 0,
	i_lr_max		:= 1000000,
	io_lr_value	:= lr_set_pos);
di_set_pos := LREAL_TO_DINT(lr_set_pos);

(* plc *)
fb_channel_1(
	l_t_impuls	:= t#1ms,
	i_i_range		:= 2,
	i_lr_min		:= 0,
	i_lr_max		:= 100,
	io_lr_value	:= lr_channel_1);

fb_channel_2(
	l_t_impuls	:= t#1ms,
	i_i_range		:= 1,
	i_lr_min		:= 0,
	i_lr_max		:= 50,
	io_lr_value	:= lr_channel_2);

fb_channel_3(
	l_t_impuls	:= t#1ms,
	i_i_range		:= 8,
	i_lr_min		:= -400,
	i_lr_max		:= 0,
	io_lr_value	:= lr_channel_3);

fb_channel_4(
	l_t_impuls	:= t#1ms,
	i_i_range		:= 5,
	i_lr_min		:= 0,
	i_lr_max		:= 250,
	io_lr_value	:= lr_channel_4);

fb_channel_5(
	l_t_impuls	:= t#1ms,
	i_i_range		:= 5,
	i_lr_min		:= -250,
	i_lr_max		:= 0,
	io_lr_value	:= lr_channel_5);

fb_channel_6(
	l_t_impuls	:= t#1ms,
	i_i_range		:= 4,
	i_lr_min		:= 0,
	i_lr_max		:= 200,
	io_lr_value	:= lr_channel_6);

fb_channel_7(
	l_t_impuls	:= t#1ms,
	i_i_range		:= 10,
	i_lr_min		:= 0,
	i_lr_max		:= 500,
	io_lr_value	:= lr_channel_7);

fb_channel_8(
	l_t_impuls	:= t#1ms,
	i_i_range		:= 10,
	i_lr_min		:= -500,
	i_lr_max		:= 0,
	io_lr_value	:= lr_channel_8);                 §џџџ                   "   STANDARD.LIB 5.6.98 11:03:02 @FДw5      CONCAT @                	   CTD @        	   CTU @        
   CTUD @           DELETE @           F_TRIG @        
   FIND @           INSERT @        
   LEFT @        	   LEN @        	   MID @           R_TRIG @           REPLACE @           RIGHT @           RS @        
   SEMA @           SR @        	   TOF @        	   TON @           TP @              Global Variables 0 @                                             2                џџџџџџџџџџџџџџџџ  
             њџџџ  Pч р<А        јџџџ                             	   Bausteine                 fb_axis_simulator  $                  MAIN      џџџџ          
   Datentypen  џџџџ             Visualisierungen  џџџџ               Globale Variablen                 Global_Variables                     TwinCAT_Configuration                     Variable_Configuration  	   џџџџ                                                              iчj@                         	   localhost            P      	   localhost            P      	   localhost            P             (r:П