package oa.ingenico;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MoneyChangeDevice {
	Map<Double, Integer> state;
	DecimalFormat df = new DecimalFormat("0.00");
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String state = scanner.nextLine();
		MoneyChangeDevice device = new MoneyChangeDevice(state);
		Integer count = Integer.valueOf(scanner.next());
		for (int i = 1; i <= count; i++) {
			System.out.println(device.makeChangeForAmount(scanner.next()));
		}
		scanner.close();
	}

	public MoneyChangeDevice(String initialSetup) {
		String[] setup = initialSetup.split("\\s|:");
		state = new TreeMap(Collections.reverseOrder());
		for (int i = 0; i < setup.length; i++) {
			state.put(Double.valueOf(setup[i]), Integer.valueOf(setup[++i]));
		}
		// System.out.println("Intial Setup" + Arrays.toString(setup));
		// System.out.println("Intial state" + state);
	}

	public String makeChangeForAmount(String amount) {
		String result = "";
		String stateStr = "";
		Double dAmount = Double.valueOf(amount);
		Map<Double, Integer> newState = new TreeMap(Collections.reverseOrder());
		newState.putAll(state);
		for (Map.Entry<Double, Integer> row : newState.entrySet()) {
			Double change = dAmount / row.getKey();
			Integer changeInt = change.intValue();
			if (change.intValue() > 0) {
				if(!result.isEmpty()) result += " ";
				if (changeInt < row.getValue()) {
					row.setValue(row.getValue() - changeInt);
					dAmount -= changeInt * row.getKey();
					result += df.format(row.getKey()) + ":" + changeInt;
				} else {
					result += df.format(row.getKey()) + ":" + row.getValue();
					dAmount -= row.getValue() * row.getKey();
					row.setValue(0);
				}

			}
			if(!stateStr.isEmpty()) stateStr += " ";
			stateStr += df.format(row.getKey()) + ":" + row.getValue();
			if (dAmount == 0d) {
				state = newState;
			}
		}
		if (dAmount != 0d) {
			result = "no change is possible for " + amount + "\\n";
		} else {
			result += "; " + stateStr + "\\n";
		}

		// System.out.println("amount:" + amount+ ", newState" + state);
		//System.out.println(result);
		return result;
	}
	
	//for testing only
		public static void main2(String[] args) {
			String state = "0.50:200 10.00:100 5.00:100";// value:quantity value:quantity ...
			//List<String> input = new ArrayList(Arrays.asList("4", "25.00", "7.50", "5.25", "14.00"));
			List<String> input = new ArrayList(Arrays.asList("5", "1010.00", "25.00", "7.50", "5.25", "14.00"));
			MoneyChangeDevice device = new MoneyChangeDevice(state);
			for (int i = 1; i <= Integer.valueOf(input.get(0)); i++) {
				device.makeChangeForAmount(input.get(i));
			}
		}
		
/*
0.50:200 10.00:100 5.00:100
4
25.00
7.50
5.25
14.00

	*/

}
