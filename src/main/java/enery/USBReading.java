package enery;

import org.openmuc.jsml.structures.SmlFile;

import java.util.ArrayList;

public final class USBReading {

	private static USBReading INSTANCE;
	private static USBConnector usbCon = null;

	private USBReading() {
		usbCon = new USBConnector();
		usbCon.open();
	}

	public static USBReading getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new USBReading();
		}
		return INSTANCE;
	}

	public SmlFile readSMLFileFromUSB() {
		if(usbCon != null && usbCon.hasConnection())
		{
			try
			{
				return usbCon.getConnection().getSMLFile();
			}
			catch(java.io.IOException ex)
			{
				System.out.println("Error in reading from USB device");
				if(ex.getLocalizedMessage().contains("Timeout"))
				{
					int timeout = usbCon.getTimeout();

					if(timeout > -1)
					{
						System.out.println("Details: Timeout " + timeout + " ms  elapsed");
					}
					else
					{
						System.out.println("Details: Timeout elapsed");
					}
				}
				else
				{
					System.out.println("Details: \"" + ex.getLocalizedMessage() +"\"");
				}
			}
		}
		return null;
	}

}
