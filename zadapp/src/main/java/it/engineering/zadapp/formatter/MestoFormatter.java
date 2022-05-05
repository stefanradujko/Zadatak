package it.engineering.zadapp.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import it.engineering.zadapp.dto.MestoDto;
import it.engineering.zadapp.service.MestoService;

@Component
public class MestoFormatter implements Formatter<MestoDto> {
	@Autowired
	private MestoService mestoService;

	@Override
	public String print(MestoDto mestoDto, Locale locale) {
		return mestoDto.getPttBroj() + "";
	}

	@Override
	public MestoDto parse(String text, Locale locale) throws ParseException {
		return mestoService.findById(Integer.parseInt(text));
	}
	

}
