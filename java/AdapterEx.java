
public class AdapterEx

{

    public static void main(String[] args)
    {
        SocketAdapter socketAdapter = new SocketAdapterImpl();
        Voltage voltage12 = socketAdapter.get12Voltage();
        System.out.println(voltage12.getVolts());

        Voltage voltage3 = socketAdapter.get3VVoltage();
        System.out.println(voltage3.getVolts());

        Voltage voltage120 = socketAdapter.get120Voltage();
        System.out.println(voltage120.getVolts());
    }
}

 class Socket
{
    public Voltage getVoltage()
    {
        return new Voltage(120); //In India 240 is the default voltage
    }
}

 interface SocketAdapter
{
     public Voltage get120Voltage();
     public Voltage get12Voltage();
     public Voltage get3VVoltage();
} 


 class SocketAdapterImpl extends Socket implements SocketAdapter
{

    //Using Composition for adapter pattern
    private Socket sock = new Socket();
    private Voltage convertVolt(Voltage v, int i)
    {
        return new Voltage(v.getVolts() / i);
    }
    @Override
    public Voltage get120Voltage()
    {
        return sock.getVoltage();
    }
    @Override
    public Voltage get12Voltage()
    {
        Voltage v = sock.getVoltage();
        return convertVolt(v, 20);
    }
    @Override
    public Voltage get3VVoltage()
    {
        Voltage v = sock.getVoltage();
        return convertVolt(v, 80);
    }
}


 class Voltage
{
    private int voltage;
    public Voltage(int v)
    {
        this.voltage = v;
    }
    public int getVolts()
    {
        return voltage;
    }
    public void setVolts(int voltage)
    {
        this.voltage = voltage;
    }
}