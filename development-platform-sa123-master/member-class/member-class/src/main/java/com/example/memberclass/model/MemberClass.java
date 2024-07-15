package com.example.memberclass.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

@Entity
@Table(name= "memberClass")
@Data
public class MemberClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer classId;
    @Enumerated(EnumType.STRING)
    private ClassType classType;

    private String description;

    private int duration;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    private int MaxCapacity; // Add this field





    // Constructors, getters and setters
    public MemberClass() {
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    private static final Map<ClassType, String> classDescriptions = new EnumMap<>(ClassType.class);

    static {
        // Initialize the descriptions for each class type
        classDescriptions.put(ClassType.Yoga, "A relaxing class focusing on flexibility and breath.");
        classDescriptions.put(ClassType.Weightlifting, "A strength class aimed at improving muscle tone and endurance.");
        classDescriptions.put(ClassType.Aerobics, "A fast-paced class that improves cardiovascular health and stamina.");
        classDescriptions.put(ClassType.Cycling, "An intense cycling session aimed at burning calories.");
        classDescriptions.put(ClassType.Zumba, "A fun, dance-based workout suitable for all fitness levels.");
        classDescriptions.put(ClassType.Cardio, "A high-intensity class designed to increase heart rate and fitness.");
    }


    // Enum for predefined class types
    public enum ClassType {
        Yoga, Weightlifting, Aerobics, Cycling, Zumba, Cardio
    }

    // Getters and setters


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public static String getDescriptionForClassType(ClassType type) {
        return classDescriptions.get(type);
    }
    public int getCapacity() {
        return MaxCapacity;
    }
    public void setCapacity(int MaxCapacity) {
        this.MaxCapacity = MaxCapacity;
    }
}
