package com.laborator.FootballDatabase.Domain;
import javax.persistence.*;
@Entity
@Table(name = "stadiums")
public class Stadium {
    @Id
    private String name;
    private String location;
    private Team team;

    // Private constructor to enforce the use of the builder
    private Stadium(String name, String location, Team team) {
        this.name = name;
        this.location = location;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Team getTeam() {
        return team;
    }

    public void setName(String name){
        this.name= this.name;
    }
    // Static method to get a new builder instance
    public static Builder builder() {
        return new Builder();
    }

    // Builder class
    public static class Builder {
        private String name;
        private String location;
        private Team team;

        // Private constructor to prevent direct instantiation
        private Builder() {
        }

        // Setter methods for optional parameters
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder team(Team team) {
            this.team = team;
            return this;
        }

        // Build method to create the Stadium object
        public Stadium build() {
            // Validate required fields
            if (name == null || location == null || team == null) {
                throw new IllegalStateException("Name, location, and team are required");
            }

            // Create and return the Stadium object
            return new Stadium(name, location, team);
        }
    }
}
