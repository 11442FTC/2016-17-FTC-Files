
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;



/**
 * Created by ethan.hampton/byron.nice on 10/31/2016.
 * <p>
 * Very simple Teleop with arm
 */

@TeleOp(name = "Simple Teleop with Arm", group = "Test")
public class byronHardware extends OpMode {

    byron byron       = new byron();

    private double left;
    private double right;
    private double arm;

    @Override
    public void init() {byron.init(hardwareMap);
    }

    @Override
    public void loop() {
        // Run wheels in tank mode
        // In this mode the Left stick moves the left wheel forward and backwards and the right moves the right wheel
        left = gamepad1.left_stick_y;
        right = gamepad1.right_stick_y;
        arm = gamepad2.right_stick_y;
        //sets the robots motor power for both motors
        byron.leftMotor.setPower(left);
        byron.rightMotor.setPower(right);
        byron.armMotor.setPower(arm);
    }
}
