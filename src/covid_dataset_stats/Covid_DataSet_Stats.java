
package covid_dataset_stats;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Get_Data_From_CSV{
    
    private int size=0;
    private String fileName ;
private List<String> iso_code =new ArrayList(); 
private List<String>continent  =new ArrayList(); 
private List<String> location =new ArrayList(); 
private List<String>  date=new ArrayList(); 
private List<String> total_cases =new ArrayList(); 
private List<String> new_cases =new ArrayList(); 
private List<String> new_cases_smothed =new ArrayList(); 
private List<String>total_deaths=new ArrayList(); 
private List<String> new_deaths=new ArrayList(); 
private List<String>new_deaths_smoothed =new ArrayList(); 
private List<String> reproduction_rate =new ArrayList(); 
private List<String>new_tests   =new ArrayList(); 
private List<String> total_tests =new ArrayList(); 
private List<String>stringency_index =new ArrayList(); 
private List<String>population  =new ArrayList(); 
private List<String>median_age  =new ArrayList(); 


Get_Data_From_CSV(String path){
    this.fileName=path;
}

void Read_Data(){
    	try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
	List<List<String>>  values = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
        size=values.size();
                        
        //read colom-1 using stream for iteration  using lambda 
	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> iso_code.add(values.get(CLO).get(0)));
    //--------------------------------------------------------------------    
    	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> continent.add(values.get(CLO).get(1)));
  //--------------------------------------------------------------------
  	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> location.add(values.get(CLO).get(2)));
   //-------------------------------------------------------------------- 
    //-------------------------------------------------------------------- 
   	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> date.add(values.get(CLO).get(3)));
  //-------------------------------------------------------------------- 
   	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> total_cases.add(values.get(CLO).get(4)));
  //-------------------------------------------------------------------- 
   	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> new_cases.add(values.get(CLO).get(5)));
   //--------------------------------------------------------------------
     //-------------------------------------------------------------------- 
   	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> new_cases_smothed.add(values.get(CLO).get(6)));
   //--------------------------------------------------------------------
     
//-------------------------------------------------------------------- 
   	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> total_deaths .add(values.get(CLO).get(7)));
   //--------------------------------------------------------------------

//-------------------------------------------------------------------- 
   	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> new_deaths .add(values.get(CLO).get(8)));
   //--------------------------------------------------------------------
     //-------------------------------------------------------------------- 
   	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> new_deaths_smoothed.add(values.get(CLO).get(9)));
   //--------------------------------------------------------------------
     //-------------------------------------------------------------------- 
   	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> reproduction_rate.add(values.get(CLO).get(16)));
   //--------------------------------------------------------------------
     //-------------------------------------------------------------------- 
   	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> new_tests .add(values.get(CLO).get(25)));
   //--------------------------------------------------------------------
     //-------------------------------------------------------------------- 
   	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> total_tests.add(values.get(CLO).get(26)));
        
   //--------------------------------------------------------------------
     //-------------------------------------------------------------------- 
   	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> stringency_index.add(values.get(CLO).get(47)));
        
   //--------------------------------------------------------------------
   
        //-------------------------------------------------------------------- 
   	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> population.add(values.get(CLO).get(48)));
        
   //--------------------------------------------------------------------
             //-------------------------------------------------------------------- 
   	Stream.iterate(0, start -> start + 1)
                .limit(values.size())
                .forEach(CLO -> median_age.add(values.get(CLO).get(49)));
        
   //--------------------------------------------------------------------
   //removing header
 iso_code .remove(0);
 total_cases.remove(0);
 continent.remove(0); 
 location .remove(0);
 date .remove(0);
 total_cases .remove(0);
 new_cases .remove(0);
 new_cases_smothed .remove(0);
 total_deaths .remove(0);
 new_deaths .remove(0);
 new_deaths_smoothed .remove(0);
 reproduction_rate .remove(0);
 new_tests .remove(0);
 total_tests .remove(0);
 stringency_index.remove(0);
 population .remove(0);
 median_age .remove(0);
   //-------------------------------------------------------------------
		} catch (IOException e) {
	}
}
      void display(int range,String by,String prt)
           {
          
        // DATE, COUNTRY, CONTINENT.
     if("DATE".equals(prt)){
         //date
         switch(by){
             case "COD":
                 System.out.println(" \nIso_codes(COD)  --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+iso_code.get(CLO)+" --- "+date.get(CLO)));
                 
                 break;
             case "CNT":
                 System.out.println(" \nContinent (CNT)  --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+continent.get(CLO)+" --- "+date.get(CLO)));
                 break; 
            case "LOC":
                System.out.println(" \nLocations (LOC)  --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+location.get(CLO)+" --- "+date.get(CLO)));
                 break;
                
                 case "DT":
                 System.out.println(" \nDates --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+date.get(CLO)+" --- "+date.get(CLO)));
                 break;
        case "TC":
         if(range==5){
         System.out.println(" \nTotal_Cases --- DATES ");    
//         -----------------------------------------------------------
         int maxNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=total_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  total_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  total_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  total_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  total_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  total_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nTotal_Cases --- DATES ");    
//         -----------------------------------------------------------
         int minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nTotal_Cases --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+total_cases.get(CLO)+" --- "+date.get(CLO)));
              }
                  
                  
                 break;
        case "NC":
             
 if(range==5){
         System.out.println(" \nNew_Cases --- DATES ");    
//         -----------------------------------------------------------
         int maxNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=new_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nnew_cases --- DATES ");    
//         -----------------------------------------------------------
         int minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nnew_cases --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+new_cases.get(CLO)+" --- "+date.get(CLO)));
              }
                  
                  
                 break;
                 
        case "NCS":
            
           if(range==5){
         System.out.println(" \nnew_cases_smothed_Smoothed --- DATES ");    
//         -----------------------------------------------------------
         int maxNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=new_cases_smothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases_smothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases_smothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases_smothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases_smothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases_smothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nnew_cases_smothed --- DATES ");    
//         -----------------------------------------------------------
         int minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases_smothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases_smothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases_smothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases_smothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases_smothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases_smothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases_smothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases_smothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases_smothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_cases_smothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nnew_cases_smothed --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+new_cases_smothed.get(CLO)+" --- "+date.get(CLO)));
              }
                  
                  
                 break;  
        case "TD":
             if(range==5){
         System.out.println(" \nTotal_deaths --- DATES ");    
//         -----------------------------------------------------------
         int maxNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=total_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  total_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  total_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  total_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  total_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  total_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \ntotal_deaths --- DATES ");    
//         -----------------------------------------------------------
         int minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \ntotal_deaths --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+total_deaths.get(CLO)+" --- "+date.get(CLO)));
              }
                  
                  
                 break;
                 
        case "ND":
             if(range==5){
         System.out.println(" \nnew_deaths --- DATES ");    
//         -----------------------------------------------------------
         int maxNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=new_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nnew_deaths --- DATES ");    
//         -----------------------------------------------------------
         int minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nnew_deaths --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+new_deaths.get(CLO)+" --- "+date.get(CLO)));
              }
                  
                  
                 break;
                 
        case "NDS":
             if(range==5){
         System.out.println(" \nnew_deaths_smoothed_smoothed --- DATES ");    
//         -----------------------------------------------------------
         int maxNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=new_deaths_smoothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths_smoothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths_smoothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths_smoothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths_smoothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths_smoothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nnew_deaths_smoothed --- DATES ");    
//         -----------------------------------------------------------
         int minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths_smoothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths_smoothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths_smoothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths_smoothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths_smoothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths_smoothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths_smoothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths_smoothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths_smoothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_deaths_smoothed.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nnew_deaths_smoothed --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+new_deaths_smoothed.get(CLO)+" --- "+date.get(CLO)));
              }
                  
                  
                 break;
        case "RR":
             if(range==5){
         System.out.println(" \nreproduction_rate --- DATES ");    
//         -----------------------------------------------------------
         int maxNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=reproduction_rate.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  reproduction_rate.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  reproduction_rate.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  reproduction_rate.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  reproduction_rate.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  reproduction_rate.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nreproduction_rate --- DATES ");    
//         -----------------------------------------------------------
         int minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  reproduction_rate.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  reproduction_rate.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  reproduction_rate.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  reproduction_rate.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  reproduction_rate.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  reproduction_rate.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  reproduction_rate.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  reproduction_rate.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  reproduction_rate.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  reproduction_rate.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nreproduction_rate --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+reproduction_rate.get(CLO)+" --- "+date.get(CLO)));
              }
                  
                  
                 break;
        case "NT":
             if(range==5){
         System.out.println(" \nnew_tests --- DATES ");    
//         -----------------------------------------------------------
         int maxNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=new_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  new_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nnew_tests --- DATES ");    
//         -----------------------------------------------------------
         int minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  new_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nnew_tests --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+new_tests.get(CLO)+" --- "+date.get(CLO)));
              }
                  
                  
                 break;
        case "TT":
           if(range==5){
         System.out.println(" \ntotal_tests --- DATES ");    
//         -----------------------------------------------------------
         int maxNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=total_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  total_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  total_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  total_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  total_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  total_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \ntotal_tests --- DATES ");    
//         -----------------------------------------------------------
         int minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  total_tests.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \ntotal_tests --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+total_tests.get(CLO)+" --- "+date.get(CLO)));
              }
                  
                  
                 break;
        case "si":
             if(range==5){
         System.out.println(" \nstringency_index --- DATES ");    
//         -----------------------------------------------------------
         int maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nstringency_index --- DATES ");    
//         -----------------------------------------------------------
         int minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nstringency_index --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+stringency_index.get(CLO)+" --- "+date.get(CLO)));
              }
                  
                  
                 break;
        case "POP":
             if(range==5){
         System.out.println(" \npopulation --- DATES ");    
//         -----------------------------------------------------------
         int maxNum = population.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nstringency_index --- DATES ");    
//         -----------------------------------------------------------
         int minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  stringency_index.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nstringency_index --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+stringency_index.get(CLO)+" --- "+date.get(CLO)));
              }
                  
                  
                 break;
        case "MA":
                 if(range==5){
         System.out.println(" \nmedian_age --- DATES ");    
//         -----------------------------------------------------------
         int maxNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=median_age.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  median_age.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  median_age.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  median_age.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  median_age.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(date.get(index));
                  median_age.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nmedian_age --- DATES ");    
//         -----------------------------------------------------------
         int minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  median_age.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  median_age.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  median_age.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  median_age.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  median_age.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  median_age.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  median_age.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  median_age.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  median_age.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(date.get(index));
                  median_age.remove(index);
                  date.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nmedian_age --- DATES ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+median_age.get(CLO)+" --- "+date.get(CLO)));
              }
                  
                  
                 break;
        default:
          System.out.println("You have entered wrong command pattern !");
          System.exit(0);
       
         }         
     }
     
    else if("COUNTRY".equals(prt)){
    
//          ..country
         switch(by){
             case "COD":
                 System.out.println(" \nIso_codes(COD)  --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+iso_code.get(CLO)+" --- "+location.get(CLO)));
                 
                 break;
             case "CNT":
                 System.out.println(" \nContinent (CNT)  --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+continent.get(CLO)+" --- "+location.get(CLO)));
                 break; 
            case "LOC":
                System.out.println(" \nLocations (LOC)  --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+location.get(CLO)+" --- "+location.get(CLO)));
                 break;
                
                 case "DT":
                 System.out.println(" \nCOUNTRY --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+location.get(CLO)+" --- "+location.get(CLO)));
                 break;
        case "TC":
         if(range==5){
         System.out.println(" \nTotal_Cases --- COUNTRY ");    
//         -----------------------------------------------------------
         int maxNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=total_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  total_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  total_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  total_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  total_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  total_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nTotal_Cases --- COUNTRY ");    
//         -----------------------------------------------------------
         int minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nTotal_Cases --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+total_cases.get(CLO)+" --- "+location.get(CLO)));
              }
                  
                  
                 break;
        case "NC":
             
 if(range==5){
         System.out.println(" \nNew_Cases --- COUNTRY ");    
//         -----------------------------------------------------------
         int maxNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=new_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nnew_cases --- COUNTRY ");    
//         -----------------------------------------------------------
         int minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nnew_cases --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+new_cases.get(CLO)+" --- "+location.get(CLO)));
              }
                  
                  
                 break;
                 
        case "NCS":
            
           if(range==5){
         System.out.println(" \nnew_cases_smothed_Smoothed --- COUNTRY ");    
//         -----------------------------------------------------------
         int maxNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=new_cases_smothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases_smothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases_smothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases_smothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases_smothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases_smothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nnew_cases_smothed --- COUNTRY ");    
//         -----------------------------------------------------------
         int minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases_smothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases_smothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases_smothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases_smothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases_smothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases_smothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases_smothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases_smothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases_smothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_cases_smothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_cases_smothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_cases_smothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nnew_cases_smothed --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+new_cases_smothed.get(CLO)+" --- "+location.get(CLO)));
              }
                  
                  
                 break;  
        case "TD":
             if(range==5){
         System.out.println(" \nTotal_deaths --- COUNTRY ");    
//         -----------------------------------------------------------
         int maxNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=total_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  total_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  total_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  total_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  total_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  total_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \ntotal_deaths --- COUNTRY ");    
//         -----------------------------------------------------------
         int minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \ntotal_deaths --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+total_deaths.get(CLO)+" --- "+location.get(CLO)));
              }
                  
                  
                 break;
                 
        case "ND":
             if(range==5){
         System.out.println(" \nnew_deaths --- COUNTRY ");    
//         -----------------------------------------------------------
         int maxNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=new_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nnew_deaths --- COUNTRY ");    
//         -----------------------------------------------------------
         int minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nnew_deaths --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+new_deaths.get(CLO)+" --- "+location.get(CLO)));
              }
                  
                  
                 break;
                 
        case "NDS":
             if(range==5){
         System.out.println(" \nnew_deaths_smoothed_smoothed --- COUNTRY ");    
//         -----------------------------------------------------------
         int maxNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=new_deaths_smoothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths_smoothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths_smoothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths_smoothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths_smoothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths_smoothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nnew_deaths_smoothed --- COUNTRY ");    
//         -----------------------------------------------------------
         int minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths_smoothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths_smoothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths_smoothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths_smoothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths_smoothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths_smoothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths_smoothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths_smoothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths_smoothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_deaths_smoothed.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_deaths_smoothed.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_deaths_smoothed.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nnew_deaths_smoothed --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+new_deaths_smoothed.get(CLO)+" --- "+location.get(CLO)));
              }
                  
                  
                 break;
        case "RR":
             if(range==5){
         System.out.println(" \nreproduction_rate --- COUNTRY ");    
//         -----------------------------------------------------------
         int maxNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=reproduction_rate.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  reproduction_rate.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  reproduction_rate.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  reproduction_rate.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  reproduction_rate.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  reproduction_rate.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nreproduction_rate --- COUNTRY ");    
//         -----------------------------------------------------------
         int minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  reproduction_rate.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  reproduction_rate.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  reproduction_rate.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  reproduction_rate.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  reproduction_rate.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  reproduction_rate.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  reproduction_rate.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  reproduction_rate.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  reproduction_rate.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = reproduction_rate.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=reproduction_rate.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  reproduction_rate.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nreproduction_rate --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+reproduction_rate.get(CLO)+" --- "+location.get(CLO)));
              }
                  
                  
                 break;
        case "NT":
             if(range==5){
         System.out.println(" \nnew_tests --- COUNTRY ");    
//         -----------------------------------------------------------
         int maxNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=new_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  new_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nnew_tests --- COUNTRY ");    
//         -----------------------------------------------------------
         int minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = new_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=new_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  new_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nnew_tests --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+new_tests.get(CLO)+" --- "+location.get(CLO)));
              }
                  
                  
                 break;
        case "TT":
           if(range==5){
         System.out.println(" \ntotal_tests --- COUNTRY ");    
//         -----------------------------------------------------------
         int maxNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=total_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  total_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  total_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  total_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  total_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  total_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \ntotal_tests --- COUNTRY ");    
//         -----------------------------------------------------------
         int minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = total_tests.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=total_tests.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  total_tests.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \ntotal_tests --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+total_tests.get(CLO)+" --- "+location.get(CLO)));
              }
                  
                  
                 break;
        case "si":
             if(range==5){
         System.out.println(" \nstringency_index --- COUNTRY ");    
//         -----------------------------------------------------------
         int maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nstringency_index --- COUNTRY ");    
//         -----------------------------------------------------------
         int minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nstringency_index --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+stringency_index.get(CLO)+" --- "+location.get(CLO)));
              }
                  
                  
                 break;
        case "POP":
             if(range==5){
         System.out.println(" \npopulation --- COUNTRY ");    
//         -----------------------------------------------------------
         int maxNum = population.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nstringency_index --- COUNTRY ");    
//         -----------------------------------------------------------
         int minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = stringency_index.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=stringency_index.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  stringency_index.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nstringency_index --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+stringency_index.get(CLO)+" --- "+location.get(CLO)));
              }
                  
                  
                 break;
        case "MA":
                 if(range==5){
         System.out.println(" \nmedian_age --- COUNTRY ");    
//         -----------------------------------------------------------
         int maxNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
        int index=median_age.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  median_age.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
                  
//         -----------------------------------------------------------
          maxNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  median_age.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                 
 //         -----------------------------------------------------------
          maxNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  median_age.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                  
   //         -----------------------------------------------------------
          maxNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  median_age.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------                
    //         -----------------------------------------------------------
          maxNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(maxNum));
                  System.out.print(maxNum+" ---- ");
                  System.out.println(location.get(index));
                  median_age.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------               
                  
              }
              else if(range==10){
                  System.out.println(" \nmedian_age --- COUNTRY ");    
//         -----------------------------------------------------------
         int minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
        int index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  median_age.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  median_age.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  median_age.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  median_age.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  median_age.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  median_age.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  median_age.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  median_age.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  median_age.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------
//         -----------------------------------------------------------
          minNum = median_age.stream()
        .mapToInt(Integer::parseInt)
        .min()
        .orElse(-1);
         index=median_age.indexOf(Integer.toString(minNum));
                  System.out.print(minNum+" ---- ");
                  System.out.println(location.get(index));
                  median_age.remove(index);
                  location.remove(index);
//                  ---------------------------------------------------------------


              }
              else{
                  System.out.println(" \nmedian_age --- COUNTRY ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+median_age.get(CLO)+" --- "+location.get(CLO)));
              }
                  
                  
                 break;
        default:
          System.out.println("You have entered wrong command pattern !");
          System.exit(0);
   
                 
         }
         
      }

 //================================================================================================
 else if("CONTINENT".equals(prt)){
     
         //continent
         switch(by){
             case "COD":
                 System.out.println(" \nIso_codes(COD)  --- CONTINENT ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+iso_code.get(CLO)+" --- "+continent.get(CLO)));
                 
                 break;
             case "CNT":
                 System.out.println(" \nContinent (CNT)  --- CONTINENT ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+continent.get(CLO)+" --- "+continent.get(CLO)));
                 break; 
            case "LOC":
                System.out.println(" \nLocations (LOC)  --- CONTINENT ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+location.get(CLO)+" --- "+continent.get(CLO)));
                 break;
                
                 case "DT":
                 System.out.println(" \nDates --- CONTINENT ");
                 Stream.iterate(0, start -> start + 1)
                .limit(range)
                .forEach(CLO ->System.out.println("    "+continent.get(CLO)+" --- "+continent.get(CLO)));
                 break;
                 default:
          System.out.println("You have entered wrong command pattern !");
          System.exit(0);
       
         }         
      
     
     
     
     
     }
       
        
          

    }
    
    
    }
   

public class Covid_DataSet_Stats {

    
    public static void main(String[] args) {

            
       

        System.out.println("-file pathToFile -param1 value1 -param2 value2 … -paramN valueN \n\nEnter a Command in above formate :\n");
        Scanner input= new Scanner(System.in);
        String Command= input.nextLine();
        System.out.println(Command);
        String[] tokens=Command.split(" ");
        int range=0;																					//ketu ishte 6
      if("-file".equals(tokens[0]) && "-stat".equals(tokens[2]) && "-limit".equals(tokens[4]) &&"-by".equals(tokens[6]) && "-display".equals(tokens[8])    ){
          if("max".equals(tokens[3])){
              //range 5
              range=5;
          }
          else if( "min".equals(tokens[3]))
          {//range 10
              range=10;
          }
          else{
              if(Integer.parseInt(tokens[5])- Integer.parseInt(tokens[3])<100  )
              {
                  range=Integer.parseInt(tokens[5])- Integer.parseInt(tokens[3]);
              }
              else{
                  System.out.println("You Have Entered wrong Range, (Range can't be grater then >100 )");
                  System.exit(0);
              }
          }
          
          
     
   Get_Data_From_CSV a=new Get_Data_From_CSV(tokens[1]);
    a.Read_Data();
    a.display(range,tokens[7],tokens[9]);

      }
      else{
          System.out.println("You have entered wrong command pattern !");
          System.exit(0);
      }

                
    }
    
    
}
