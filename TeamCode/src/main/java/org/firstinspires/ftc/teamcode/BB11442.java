package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="BB11442", group="Test")
public class BB11442 extends OpMode {


    BBHardware robot = new BBHardware();


    double lefthandPosition = robot.LEFTHAND_HOME;
    final double LEFTHAND_SPEED = 0.01;
    double beaconPosition = robot.BEACON_HOME;
    final double BEACON_SPEED = 0.01;
    private static boolean slidemoving = false;
    private static boolean launchmoving = false;

    @Override
    public void init() {
        robot.init(hardwareMap);
        robot.launch.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    @Override
    public void loop() {

        float throttle = -gamepad1.left_stick_y;
        float direction = gamepad1.right_stick_x;

        float right = throttle - direction;
        float left = throttle + direction;


        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1, 1);


        right = (float) scaleInput(right);
        left = (float) scaleInput(left);


        robot.rightMotor.setPower(right);
        robot.leftMotor.setPower(left);

        if (gamepad1.dpad_up) {
            robot.lift.setTargetPosition(41100);
            //1 rotation = 1560 ticks
            //15 rotations
            robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.lift.setPower(1);
            slidemoving = true;
        }
        if(!robot.lift.isBusy()){
            robot.lift.setPower(0);
        }
        if (gamepad1.dpad_down) {
            robot.lift.setPower(0.75);
        } else if (slidemoving == false) {
            robot.lift.setPower(0);
        }

        if (slidemoving && !robot.lift.isBusy()) {
            robot.lift.setPower(0);
            slidemoving = false;
        }

        if (gamepad2.a) {
            robot.spin.setPower(0);
        }
        if (gamepad2.b) {
            robot.spin.setPower(-1);
        }

        if (gamepad1.x) {
            lefthandPosition += LEFTHAND_SPEED;
        }

        else if (gamepad1.b) {
            lefthandPosition -= LEFTHAND_SPEED;
        }

        if (gamepad2.left_bumper) {
            beaconPosition += BEACON_SPEED;
        }

        else if (gamepad2.right_bumper) {
            beaconPosition -= BEACON_SPEED;
        }

        if (gamepad2.dpad_up) {
            robot.launch.setTargetPosition(robot.launch.getTargetPosition()+1600);
            //1 rotation = 1560 ticks
            robot.launch.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.launch.setPower(0.2);
            launchmoving = true;

        }

        if(!robot.launch.isBusy()){
            robot.launch.setPower(0);
        }
        if (gamepad2.dpad_down) {
            robot.launch.setPower(0);
        } else if (launchmoving == false) {
            robot.launch.setPower(0);
        }

        if (launchmoving && !robot.launch.isBusy()) {
            robot.launch.setPower(0);
            launchmoving = false;
        }


        lefthandPosition = Range.clip(lefthandPosition, robot.LEFTHAND_MIN_RANGE, robot.LEFTHAND_MAX_RANGE);
        robot.lefthand.setPosition(lefthandPosition);

        beaconPosition = Range.clip(beaconPosition, robot.BEACON_MIN_RANGE, robot.BEACON_MAX_RANGE);
        robot.beacon.setPosition(beaconPosition);


    }

    double scaleInput(double dVal) {
        double[] scaleArray = {0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.20, 0.20, 0.24,
                0.30, 0.32, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00};

        int index = (int) (dVal * 16.0);


        if (index < 0) {
            index = -index;
        }


        if (index > 16) {
            index = 16;
        }


        double dScale;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        return dScale;
    }

}