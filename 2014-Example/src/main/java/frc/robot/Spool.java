package frc.robot;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Spool {

    CANSparkMax m_spoolMotor = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANEncoder m_spoolEncoder = m_spoolMotor.getEncoder();

    DoubleSolenoid m_latch = new DoubleSolenoid(0, 6, 7); //Change the values?

    private static Spool m_spool = null;  

    public static Spool getInstance(){
        if(m_spool == null)
            m_spool = new Spool();

        return m_spool;
    }

    public void resetEncoder(){
        m_spoolEncoder.setPosition(0);
    }

    public void spoolDown(double speed){

        m_spoolMotor.setIdleMode(IdleMode.kBrake);
        if(m_spoolEncoder.getPosition() > 1000){
            m_spoolMotor.set(speed);
        }
    }
    
    public void latch(){
        m_latch.set(Value.kForward);
    }

    public void unlatch(){

        m_spoolMotor.setIdleMode(IdleMode.kCoast);
        m_latch.set(Value.kReverse);
    }
    
}
