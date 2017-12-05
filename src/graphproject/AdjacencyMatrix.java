/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author jackson
 */
public class AdjacencyMatrix {

    ArrayList<Jobs> openPositions = new ArrayList<>();
    ArrayList<Applicant> jobSeekers = new ArrayList<>();
    ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
    static int BESTERESTSUM = 0;
    static ArrayList<Integer> bestFit = new ArrayList<>();

    public class Applicant {

        String name;
        ArrayList<Integer> jobFit = new ArrayList<>();

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the jobFit
         */
        public ArrayList<Integer> getJobFit() {
            return jobFit;
        }

        /**
         * @param jobFit the jobFit to set
         */
        public void setJobFit(ArrayList<Integer> jobFit) {
            this.jobFit = jobFit;
        }
    }

    public class Jobs {

        private String tile;

        /**
         * @return the tile
         */
        public String getTile() {
            return tile;
        }

        /**
         * @param tile the tile to set
         */
        public void setTile(String tile) {
            this.tile = tile;
        }

        /**
         * @return the jobApplicant
         */
        /**
         * @param jobApplicant the jobApplicant to set
         */
    }

    public void printJobTitles() {
        openPositions.stream().forEach((i) -> {
            System.out.println(i.getTile());
        });
    }

    public void printJobSeekers() {
        jobSeekers.stream().forEach((i) -> {
            System.out.println(i.getName());
            System.out.println(i.jobFit);
        });
    }

    public void getBestApplicant() {
        for (int i = 0; i < openPositions.size(); i++) {
            String bestApplicant = "";
            int bestScore = 0;
            for (int j = 0; j < jobSeekers.size(); j++) {
                if (jobSeekers.get(j).jobFit.get(i) > bestScore) {
                    bestScore = jobSeekers.get(j).jobFit.get(i);
                    bestApplicant = jobSeekers.get(j).name;
                }
            }
            System.out.printf("Best Fit for %s is %s\n", openPositions.get(i).tile, bestApplicant);
        };
    }

    public void optimalSolution() {
        //In a sane world this is just a range call. Streams seem cool tho.
        Integer[] input = IntStream.rangeClosed(0, jobSeekers.size() - 1)
                .boxed()
                .toArray(Integer[]::new);
        cartesian(0, input, jobSeekers, 0, 0);
        System.out.printf("The optimal job placements are: ");
        for (int i = 0; i < bestFit.size(); i++) {
            System.out.printf("For the job %s the applicant %s is the best!\n", 
                    openPositions.get(i).tile.toString(), 
                    jobSeekers.get(bestFit.get(i)).name);
        }
    }

    //Mike has the best variable names.
    public void addApplicant() {

        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter a new applicant's name: ");     //get their name
        String applicantName = input.nextLine();                        // save name
        Applicant blank = new Applicant();
        blank.name = applicantName;                                     //put mane in ArrayList

        for (int i = 0; i < openPositions.size(); i++) {                  // Move through arrayList 
            System.out.printf("Please enter %s's quality value for: %s: ", applicantName, openPositions.get(i).tile);
            //Print their name
            int daValue = input.nextInt();
            blank.jobFit.add(daValue);

        }

        jobSeekers.add(blank);//save their value for that job 
    }

    public void addPostion() {

        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter a new job title: ");              // take in new job
        String jobName = input.nextLine();
        Jobs blanco = new Jobs();
        blanco.tile = jobName;
        for (int i = 0; i < jobSeekers.size(); i++) {
            System.out.printf("Please enter the %s JobFit value of %s: ", jobName, jobSeekers.get(i).name);
            int daValue = input.nextInt();                                    //print name of applicants and ask for their jobFit

            jobSeekers.get(i).jobFit.add(daValue);         //save the value for their jobfit for that job.

        }
        openPositions.add(blanco);
    }

    public static void cartesian(int start, Integer[] input, ArrayList<Applicant> jobSeekers, int bestSum, int loopInt) {
//        System.out.printf("Loop Count: %s\n", loopInt);
        if (start == input.length) {
//            System.out.println(Arrays.toString(input));
            ArrayList<Integer> test = new ArrayList<>();
            test.addAll(Arrays.asList(input));
            int localSum = 0;
//            System.out.printf("The length of the test arraylist is: %s\n", test.size());
            for (int q = 0; q < jobSeekers.size(); q++) {
//                System.out.println(jobSeekers.get(q).jobFit.get(test.get(q)));
                localSum += jobSeekers.get(q).jobFit.get(test.get(q));
            }
            if (localSum > BESTERESTSUM) {
                BESTERESTSUM = localSum;
                bestFit = test;
            }
        }
        for (int i = start; i < input.length; i++) {
            int temp = input[i];
            input[i] = input[start];
            input[start] = temp;
            loopInt++;
            cartesian(start + 1, input, jobSeekers, bestSum, loopInt);
            int temp2 = input[i];
            input[i] = input[start];
            input[start] = temp2;
        }
    }
}
