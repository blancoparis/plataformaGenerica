package org.tfc.core.binding;

import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Component;

@Component(value = "applicationConversionService")
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean{
	
	@Override
	protected void installFormatters(FormatterRegistry registry) {
	  // Register the default date formatter provided by Spring
	  registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
	}

}
