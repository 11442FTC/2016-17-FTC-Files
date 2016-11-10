package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by laura.denney on 11/9/2016.
 */
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




        if (gamepad2.dpad_down) {
            clawRightPosition -= clawRightDelta;
        }


        // clip the position values so that they never exceed their allowed range.
        if (gamepad2.dpad_up) {
            clawRightPosition += clawRightDelta;



            clawRightPosition = Range.clip(clawRightPosition, CLAWRIGHT_MIN_RANGE, CLAWRIGHT_MAX_RANGE);
            clawLeftPosition = Range.clip(clawLeftPosition, CLAWLEFT_MIN_RANGE, CLAWLEFT_MAX_RANGE);
            clawRight.setPosition(clawRightPosition);
            clawLeft.setPosition(clawLeftPosition);
        }

    }
}
