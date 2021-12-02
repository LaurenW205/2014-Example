package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class PaddlePivot {

    DoubleSolenoid leftPaddle = new DoubleSolenoid(0,1);
    DoubleSolenoid rightPaddle = new DoubleSolenoid(2,3);
    DoubleSolenoid pivot = new DoubleSolenoid(4,5);
    private static PaddlePivot m_paddlePivot;

    public PaddlePivot() {
        
    }

    public void open(){
        leftPaddle.set(Value.kReverse);
        rightPaddle.set(Value.kReverse);
    }

    public void close(){
        leftPaddle.set(Value.kForward);
        rightPaddle.set(Value.kForward);
    }

    public void pivotUp(){
        pivot.set(Value.kForward);
    }

    public void pivotDown(){
        pivot.set(Value.kReverse);
    }

    public Value paddleState(){
        return leftPaddle.get();
    }

    public Value pivotState(){
        return pivot.get();
    }

    public static synchronized PaddlePivot getInstance(){
        if (m_paddlePivot == null)
            m_paddlePivot = new PaddlePivot();

        return m_paddlePivot;
    }
}
