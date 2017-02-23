
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file illustrates the concept of driving a path based on encoder counts.
 * It uses the common Pushbot hardware class to define the drive on the robot.
 * The code is structured as a LinearOpMode
 *
 * The code REQUIRES that you DO have encoders on the wheels,
 *   otherwise you would use: PushbotAutoDriveByTime;
 *
 *  This code ALSO requires that the drive Motors have been configured such that a positive
 *  power command moves them forwards, and causes the encoders to count UP.
 *
 *   The desired path in this example is:
 *   - Drive forward for 48 inches
 *   - Spin right for 12 Inches
 *   - Drive Backwards for 24 inches
 *   - Stop and close the claw.
 *
 *  The code is written using a method called: encoderDrive(speed, leftInches, rightInches, timeoutS)
 *  that performs the actual movement.
 *  This methods assumes that each movement is relative to the last stopping place.
 *  There are other ways to perform encoder based moves, but this method is probably the simplest.
 *  This code uses the RUN_TO_POSITION mode to enable the Motor controllers to generate the run profile
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="Pushbot: LineFollow", group="Test")

public class LineFollow extends LinearOpMode {

    /* Declare OpMode members. */
    BBHardware robot       = new BBHardware();   // Use a Pushbot's hardware
    private ElapsedTime     runtime = new ElapsedTime();


    private boolean  line = false;

    @Override
    public void runOpMode() throws InterruptedException {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        waitForStart();

        while (line == false) {
            int[] left = robot.colorSensors.getCRGB(1);
            int[] right = robot.colorSensors.getCRGB(0);

//CHANGE THIS (set this to robot.colorSensors.getCRGB(Constants.Robot.RIGHT_COLOR) when you start the robot)
            int value = 10000;//what is the value of the light sensor that signifys that it is on the line

//both are off line
            if (left[0] < value && right[0] < value) {
                robot.leftMotor.setPower(-0.1);
                robot.rightMotor.setPower(-0.1);

//left is on line
            } else if (left[0] > value && right[0] < value) {
                robot.leftMotor.setPower(0);
                robot.rightMotor.setPower(-0.1);

//right is on line
            } else if (left[0] < value && right[0] > value) {
                robot.leftMotor.setPower(-0.1);
                robot.rightMotor.setPower(0);

//both on line
            } else if (left[0] > value && right[0] > value) {
                robot.leftMotor.setPower(0);
                robot.rightMotor.setPower(0);
                //should stop line following if the code reaches this point
                line = true;
            }
        }










    }

    /*
     *  Method to perfmorm a relative move, based on encoder counts.
     *  Encoders are not reset as the move is based on the current position.
     *  Move will stop if any of three conditions occur:
     *  1) Move gets to the desired position
     *  2) Move runs out of time
     *  3) Driver stops the opmode running.
     */

}
