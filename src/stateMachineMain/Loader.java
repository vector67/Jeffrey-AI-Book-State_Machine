package stateMachineMain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Loader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(StringBuilder str:split(new StringBuilder(""),"&")){
			System.out.println(str);
		}
		
		File file = new File("Untitled.txt");
		LinkedHashMap<Integer,HierachicalStateMachine> hsmmachines = new LinkedHashMap<Integer,HierachicalStateMachine>();
		LinkedHashMap<String,Integer> hsmmachinesvalues = new LinkedHashMap<String,Integer>();
		HashMap<Integer,State> states = new HashMap<Integer,State>();
		HashMap<String,Integer> Statesnames = new HashMap<String,Integer>();
		HierachicalStateMachine currentmachine;
		int hsmmID;
		FileReader reader = null;
		BufferedReader buf = null;
		StringBuilder temp1;
		StringBuilder temp2;
		StringBuilder temp3;
		StringBuilder temp4;	
		StringBuilder[] tempar1;
		StringBuilder[] tempar2;
		StringBuilder[] tempar3;
		StringBuilder[] tempar4;
		try {
			buf = new BufferedReader(new FileReader(file));
			int linenum = 0;
			StringBuilder nextline = new StringBuilder(buf.readLine());
			linenum++;
			while(!nextline.toString().equals("")){
				// This is the header of the file
				if(nextline.indexOf("!")==-1){
					tempar1 = split(nextline, ",");
					for(StringBuilder temp5:tempar1){
						tempar2 = split(temp5,"-");
						hsmmachines.put(Integer.parseInt(tempar2[0].toString()),new HierachicalStateMachine());
						hsmmachinesvalues.put(tempar2[1].toString(),Integer.parseInt(tempar2[0].toString()));
					}
				}else {
					tempar1 = split(nextline,"!");
					if(tempar1==null){
						break;
					}
					hsmmID = Integer.parseInt(tempar1[0].toString());
					if(!hsmmachinesvalues.containsValue(hsmmID)){
						throw new UnsupportedEncodingException("The ID "+ hsmmID + " was not found in the list of state machines");
					}
					if(tempar1.length==2){
						tempar2 = split(tempar1[1],",");
						if(!hsmmachinesvalues.get(tempar2[0].toString()).equals(hsmmID)){
							String correctstr = "";
							for(Entry<String, Integer> key:( hsmmachinesvalues).entrySet()){
								String tempstr = key.getKey();
								int tempid = key.getValue();
								if(tempid==Integer.parseInt(tempar1[0].toString())){
									correctstr = tempstr;
								}
							}
							throw new UnsupportedEncodingException("The name "+tempar2[0] + " does not match the ID " + hsmmID + ", " +((hsmmachinesvalues.get(tempar2[0])!=null)?"The ID should be " + hsmmachinesvalues.get(tempar2[0]):("The name should be "+correctstr)));
						}
						currentmachine = hsmmachines.get(hsmmID);
						currentmachine.
					}else if(tempar1.length==3){
						
					}else{
						throw new UnsupportedEncodingException("There were "+tempar1.length+" arguments on line " + linenum + ".");
					}
				}
				String temper2 = buf.readLine();
				if(temper2==null){
					temper2 = "";
				}
				
				nextline = new StringBuilder(temper2);
				linenum++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//*/
		
	}
	public static StringBuilder[] split(StringBuilder str,String on){
		int index = 0;
		int cut = on.length();
		ArrayList<StringBuilder> strs = new ArrayList<StringBuilder>();
		int prev=0;
		while(str.indexOf(on)!=-1){
			index = str.indexOf(on);
			strs.add(new StringBuilder(str.substring(0,index)));
			str.delete(0, index+cut);
			prev = index;
		}
		strs.add(str);
		StringBuilder[] returnstr = new StringBuilder[strs.size()];
		return (StringBuilder[])strs.toArray(returnstr);
	}
}
