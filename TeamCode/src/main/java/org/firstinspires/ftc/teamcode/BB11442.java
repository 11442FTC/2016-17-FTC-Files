package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="BB11442", group="Test")
public class BB11442 extends OpMode {


    BBHardware robot       = new BBHardware();

    double left;
    double right;

    @Override
    public void init() {
        robot.init(hardwareMap);
    }
    @Override
    public void loop() {

        left = gamepad1.left_stick_y;
        right = gamepad1.right_stick_y;

        robot.leftMotor.setPower(left);
        robot.rightMotor.setPower(right);

        }

    }

