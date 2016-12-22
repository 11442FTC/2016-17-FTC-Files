package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="BB11442", group="Test")
public class BB11442 extends OpMode {


    BBHardware robot = new BBHardware();

    double left;
    double right;
    double          lefthandPosition     = robot.LEFTHAND_HOME;
    final double    LEFTHAND_SPEED      = 0.01 ;
    private static boolean slidemoving = false;

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {

        left = gamepad1.left_stick_y;
        right = -gamepad1.right_stick_y;

        robot.leftMotor.setPower(left);
        robot.rightMotor.setPower(right);

        if (gamepad1.dpad_up) {
            robot.lift.setTargetPosition(1560);
            //1 rotation = 1560 ticks
            //15 rotations
            robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.lift.setPower(0.75);
            slidemoving = true;
        }
        if (gamepad1.dpad_down) {
            robot.lift.setPower(-0.75);
        }
        else if (slidemoving = false){
            robot.lift.setPower(0);
        }

        if (slidemoving&&!robot.lift.isBusy()) {
            robot.lift.setPower(0);
            slidemoving = false;
        }

        if (gamepad2.a) {
            robot.spin.setPower(0.75);
        }
        if (gamepad2.b) {
            robot.spin.setPower(-0.75);
        }
        if (gamepad2.x) {
            robot.spin.setPower(0);
        }


        if (gamepad1.x)
            lefthandPosition += LEFTHAND_SPEED;
        else if (gamepad1.b)
            lefthandPosition -= LEFTHAND_SPEED;


        lefthandPosition  = Range.clip(lefthandPosition, robot.LEFTHAND_MIN_RANGE, robot.LEFTHAND_MAX_RANGE);
        robot.lefthand.setPosition(lefthandPosition);

    }
}