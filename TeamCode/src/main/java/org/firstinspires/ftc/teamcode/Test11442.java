/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TestDrive", group="Test")
public class Test11442 extends OpMode {


    HardwareTest robot       = new HardwareTest();

    double left;
    double right;

    @Override
    public void init() {
        robot.init(hardwareMap);
    }
    @Override
    public void loop() {


        float throttle = gamepad1.left_stick_y;
        float direction = -gamepad1.right_stick_x;

        float right = throttle - direction;
        float left = throttle + direction;


        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1, 1);


        right = (float) scaleInput(right);
        left = (float) scaleInput(left);


        robot.rightMotor.setPower(right);
        robot.leftMotor.setPower(left);

        float arm;
        arm = throttle - direction;
        arm = Range.clip(arm, -1, 1);
        arm = (float) scaleInput(arm);
        robot.slide.setPower(arm);


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




