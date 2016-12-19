package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="BB11442", group="Test")
public class BB11442 extends OpMode {


    BBHardware robot = new BBHardware();

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

        if (gamepad1.dpad_up) {
            robot.lift.setTargetPosition(5000);
            //1 rotation = 1560 ticks
            robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.lift.setPower(0.75);
        }
        if (gamepad1.dpad_down) {
            robot.lift.setTargetPosition(0);
            robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.lift.setPower(-0.75);
        }

        if (!robot.lift.isBusy()) {
            robot.lift.setPower(0);
        }

        if (gamepad2.a) {
            robot.spin.setPower(0.75);
        }
        if (gamepad2.x) {
            robot.spin.setPower(0);
        }

        if (gamepad2.dpad_up) {
            robot.leftb.setPower(1);
            robot.rightb.setPower(1);
        }

        if (gamepad2.dpad_down) {
            robot.leftb.setPower(0);
            robot.rightb.setPower(0);
        }


    }
}