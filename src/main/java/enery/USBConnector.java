package enery;

import gnu.io.*;
import org.openmuc.jsml.transport.SerialReceiver;

import java.io.File;
import java.io.IOException;

public class USBConnector {

    private SerialPort USB_Port         = null;
    private SerialReceiver USB_Receiver = null;

    public boolean open()
    {
        boolean status = false;

        //TODO: remove setProperties for final release
        //-Djava.library.path=/usr/lib/jni
        System.setProperty("java.library.path", "/usr/lib/jni");
        //-Dgnu.io.rxtx.SerialPorts=/dev/ttyUSB0
        System.setProperty("gnu.io.rxtx.SerialPorts","/dev/ttyUSB0");

        System.out.println("java.library.path="+System.getProperty("java.library.path"));
        System.out.println("gnu.io.rxtx.SerialPorts="+System.getProperty("gnu.io.rxtx.SerialPorts"));
        String usb_Device = System.getProperty("gnu.io.rxtx.SerialPorts");

        File usb = new File(usb_Device);
        if(!usb.exists())
        {
            System.out.println("Device '" + usb_Device + "' not existing in filesystem");
            return false;
        }

        try
        {
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(usb_Device);
            USB_Port = (SerialPort) portIdentifier.open("SML_USB",500);
            try
            {
                USB_Port.enableReceiveTimeout(1000);
            } catch (UnsupportedCommOperationException ex)
            {
                System.out.println("Unable to set timeout for usb_Device '" + usb_Device + "'");
                System.out.println("Details: '" + ex.getLocalizedMessage() +"'");
            }
            USB_Receiver = new SerialReceiver(USB_Port);
            status = true;
        }
        catch(java.io.IOException ex)
        {
            System.out.println("Unable to open usb_Device '" + usb_Device + "'");
            System.out.println("Details: '" + ex.getLocalizedMessage() +"'");
        }
        catch (NoSuchPortException ex)
        {
            System.out.println("Device '" + usb_Device + "' not existing");
            System.out.println("Details: '" + ex.getLocalizedMessage() +"'");
        }
        catch(PortInUseException ex)
        {
            System.out.println("Device '" + usb_Device + "' already in use");
            System.out.println("Details: '" + ex.getLocalizedMessage() +"'");
        }

        System.out.println("USB_Receiver is ready to use ("+USB_Receiver+")");
        return status;
    }

    public boolean hasConnection()
    {
        if(USB_Receiver == null)
            return false;
        return true;
    }

    public SerialReceiver getConnection()
    {
        return USB_Receiver;
    }

    public void close()
    {
        if(USB_Port != null)
        {
            USB_Port.close();
            USB_Port = null;
        }

        if(USB_Receiver != null)
        {
            try
            {
                USB_Receiver.closeStream();
                USB_Receiver = null;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public int getTimeout()
    {
        if(USB_Port != null)
            return USB_Port.getReceiveTimeout();
        return -1;
    }

}
