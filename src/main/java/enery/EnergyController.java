package enery;


import org.openmuc.jsml.structures.SmlFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnergyController {

	@GetMapping("/energy")
	public JsonValues energyReading() {
		SmlFile smlFile = USBReading.getInstance().readSMLFileFromUSB();
		return new SmlToJson().transform(smlFile);
	}
}
