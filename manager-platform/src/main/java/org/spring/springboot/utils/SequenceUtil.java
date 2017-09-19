package org.spring.springboot.utils;

/**
 * jony.lai
 */

import org.spring.springboot.sequence.Sequence;
import org.springframework.beans.factory.annotation.Value;

public class SequenceUtil {
	
	@Value("${sequence.workerId}")
    private static long workerId;
	
	@Value("${sequence.dataBaseId}")
    private static long dataBaseId;
	
    public SequenceUtil() {
    	
    }
    private static Sequence sequence = null;
    
    public static Sequence getSequence() {
        if(sequence == null){
        	sequence = new Sequence(workerId,dataBaseId);
        }
        return sequence;
    }



}