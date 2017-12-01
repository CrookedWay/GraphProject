/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphproject;

import java.util.ArrayList;

/**
 *
 * @author jackson
 */
public class AdjacencyMatrix {
    ArrayList<Jobs> openPositions = new ArrayList<>();
    ArrayList<Applicant> jobSeekers = new ArrayList<>();
    
    public class Applicant{
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
    public class Jobs{
        private String tile;
        private ArrayList<Applicant> jobApplicant = new ArrayList();

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
        public ArrayList<Applicant> getJobApplicant() {
            return jobApplicant;
        }

        /**
         * @param jobApplicant the jobApplicant to set
         */
        public void setJobApplicant(ArrayList<Applicant> jobApplicant) {
            this.jobApplicant = jobApplicant;
        }
    }
    public void printJobTitles(){
        openPositions.stream().forEach((i) -> {
            System.out.println(i.getTile());
        }); 
    }
    public void printJobSeekers(){
        jobSeekers.stream().forEach((i) -> {
            System.out.println(i.getName());
            System.out.println(i.jobFit);
        }); 
    }
    public void getBestApplicant(){
        for (int i =0; i < openPositions.size(); i++){
        String bestApplicant = "";
        int bestScore = 0;
            for (int j =0; j < jobSeekers.size(); j++){
                if(jobSeekers.get(j).jobFit.get(i) > bestScore){
                bestScore = jobSeekers.get(j).jobFit.get(i);
                bestApplicant = jobSeekers.get(j).name;
            } 
        }
        System.out.printf("Best Fit for %s is %s\n", openPositions.get(i).tile, bestApplicant);
    };
    
}
}
