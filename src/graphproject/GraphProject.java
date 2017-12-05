/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author jackson
 */
public class GraphProject {
    


    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        AdjacencyMatrix Prime = new AdjacencyMatrix();
        Scanner scanner = new Scanner(new File("Jobs.txt"));
        while (scanner.hasNextLine()){
            String jobTitle = scanner.nextLine();
            AdjacencyMatrix.Jobs temp = Prime.new Jobs();
            temp.setTile(jobTitle);
            Prime.openPositions.add(temp);
            }
        scanner = new Scanner(new File("Applicants.txt"));
        while (scanner.hasNextLine()){
            String applicantString = scanner.nextLine();
            String[] split = applicantString.split(",");
            AdjacencyMatrix.Applicant temp = Prime.new Applicant();
            temp.setName(split[0]);
            for (int i = 1; i<split.length;i++){
               temp.jobFit.add(Integer.parseInt(split[i]));
                   
            }
            Prime.jobSeekers.add(temp);
            }
        Prime.addPostion();
        Prime.printJobTitles();
        Prime.addApplicant();
        Prime.printJobSeekers();
        Prime.optimalSolution();
//          System.out.println("Hello");
          

        
    

    }
}
    

