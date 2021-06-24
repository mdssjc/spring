package org.springframework.samples.petclinic.sfg;

import org.springframework.stereotype.Component;

/**
 * @author Marcelo dos Santos
 */
@Component
public class LaurelWordProducer implements WordProducer {

    @Override
    public String getWord() {
        return "Laurel";
    }
}
