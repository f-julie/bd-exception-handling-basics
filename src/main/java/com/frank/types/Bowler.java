package com.frank.types;

import java.util.Arrays;
import java.util.Objects;

public class Bowler {
        String bowlerName;
        int[] scores;

        public Bowler() {
                bowlerName = "";
                scores = null;
        }

        public Bowler(String bowlerName, int[] scores) {
                this.bowlerName = bowlerName;
                this.scores     = scores;
        }

        public String getBowlerName() {
                return bowlerName;
        }

        public void setBowlerName(String bowlerName) {
                this.bowlerName = bowlerName;
        }

        public int[] getScores() {
                return scores;
        }

        public void setScores(int[] scores) {
                this.scores = scores;
        }

        // property to return derived Bowler average
        public double getAverage() {
           int totalScore = 0;  // hold total of all scores
           for (int i=0; i < scores.length; i++) {
               totalScore += scores[i];
           }
           return (double) totalScore / scores.length;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Bowler bowler = (Bowler) o;
                return getBowlerName().equals(bowler.getBowlerName()) && Arrays.equals(getScores(), bowler.getScores());
        }

        @Override
        public int hashCode() {
                int result = Objects.hash(getBowlerName());
                result = 31 * result + Arrays.hashCode(getScores());
                return result;
        }

        @Override
        public String toString() {
                return "Bowler{" +
                        "bowlerName='" + bowlerName + '\'' +
                        ", scores=" + Arrays.toString(scores) +
                        '}';
        }
}
