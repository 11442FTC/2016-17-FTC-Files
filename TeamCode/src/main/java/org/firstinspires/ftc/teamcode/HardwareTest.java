package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;


public class HardwareTest{


    public DcMotor  leftMotor;
    public DcMotor  rightMotor;




    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();



    public HardwareTest() {

    }


    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        leftMotor   = hwMap.dcMotor.get("left");
        rightMotor  = hwMap.dcMotor.get("right");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);


        leftMotor.setPower(0);
        rightMotor.setPower(0);




    }


}






