package e3;

import java.util.Objects;

public class Clock {
    private final int hours;
    private final int minutes;
    private final int seconds;
    public enum Period {AM, PM}
    private Period period;

    /**
     * Creates a Clock instance parsing a String .
     * @param s The string representing the hour in 24h format (17:25:15) or in
     * 12h format (05:25:15 PM ).
     * @throws IllegalArgumentException if the string is not a valid hour .
     */
    public Clock ( String s) {
        if (!s.matches("\\d{2}:\\d{2}:\\d{2}(\\s[A,P]M)?"))
            throw new IllegalArgumentException("String is not a valid hour: " + s);

        if (s.contains("AM") || s.contains("PM")){
            this.hours = Integer.parseInt(s.substring(0,2));
            this.minutes = Integer.parseInt(s.substring(3,5));
            this.seconds = Integer.parseInt(s.substring(6,8));

            if(s.contains("AM"))
                this.period = Period.AM;
            if(s.contains("PM"))
                this.period = Period.PM;

            if (hours < 0 || hours >= 13)
                throw new IllegalArgumentException("Hours are not valid: " + hours);

            if (minutes < 0 || minutes >= 60)
                throw new IllegalArgumentException("Minutes are not valid: " + minutes);

            if (seconds < 0 || seconds >= 60)
                throw new IllegalArgumentException("Seconds are not valid: " + seconds);
        }
        else{
            this.hours = Integer.parseInt(s.substring(0,2));
            this.minutes = Integer.parseInt(s.substring(3,5));
            this.seconds = Integer.parseInt(s.substring(6,8));

            if (hours < 0 || hours >= 24)
                throw new IllegalArgumentException("Hours is not valid: " + hours);

            if (minutes < 0 || minutes >= 60)
                throw new IllegalArgumentException("Minutes is not valid: " + minutes);

            if (seconds < 0 || seconds >= 60)
                throw new IllegalArgumentException("Seconds is not valid: " + seconds);
        }
    }

    /**
     * Creates a clock given the values in 24h format .
     * @param hours Hours in 24h format .
     * @param minutes Minutes .
     * @param seconds Seconds .
     * @throws IllegalArgumentException if the values do not represent a valid
     * hour .
     */
    public Clock ( int hours , int minutes , int seconds ) {
        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59)
            throw new IllegalArgumentException();

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * Creates a clock given the values in 12h format . Period is a enumeration
     * located inside the Clock class with two values : AM and PM.
     * @param hours Hours in 12h format .
     * @param minutes Minutes .
     * @param seconds Seconds .
     * @param period Period used by the Clock ( represented by an enum ).
     * @throws IllegalArgumentException if the values do not represent a valid
     * hour .
     */
    public Clock ( int hours , int minutes , int seconds , Period period ) {
        if (hours < 0 || hours > 12 || minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59)
            throw new IllegalArgumentException();

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.period = period;
    }

    /**
     * Returns the hours of the clock in 24h format
     * @return the hours in 24h format
     */
    public int getHours24 () {
        if (this.period == Period.AM) {
            if (hours == 12)
                return 0;
            else
                return this.hours;
        }

        if (this.period == Period.PM) {
            if (hours == 12)
                return 12;
            else
                return this.hours + 12;
        }

        else
            return this.hours;
    }
    /**
     * Returns the hours of the clock in 12h format
     * @return the hours in 12h format
     */
    public int getHours12 () {
        if (this.period == null) {
            if (hours == 0)
                return this.hours + 12;
            if (hours >= 1 && hours <= 11)
                return this.hours;
            if (hours >= 13 && hours <= 23)
                return this.hours - 12;
            else
                return this.hours;
        }

        else
            return this.hours;
    }

    /**
     * Returns the minutes of the clock
     * @return the minutes
     */
    public int getMinutes () {
        return minutes;
    }

    /**
     * Returns the seconds of the clock .
     * @return the seconds .
     */
    public int getSeconds () {
        return seconds;
    }

    /**
     * Returns the period of the day (AM or PM) that the clock is representing
     * @return An instance of the Clock . Period enum depending if the time is
     * before noon (AM) or after noon (PM ).
     */
    public Period getPeriod () {
        if (period == null){ //the clock has 24h format
            if (hours <= 12)
                return Period.AM;
            else
                return Period.PM;
        }
        else
            return period;
    }

    /**
     * Prints a String representation of the clock in 24h format .
     * @return An string in 24h format
     * @see String . format function to format integers with leading zeroes
     */
    public String printHour24 () {
        if (this.period == Period.AM) {
            if (hours == 12)
                return String.format("00:%02d:%02d", minutes, seconds);
            else
                return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }

        if (this.period == Period.PM) {
            if (hours == 12)
                return String.format("12:%02d:%02d", minutes, seconds);
            else
                return String.format("%02d:%02d:%02d", hours + 12, minutes, seconds);
        }

        else
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    /**
     * Prints a String representation of the clock in 12h format .
     * @return An string in 12h format
     * @see String . format function to format integers with leading zeroes
     */
    public String printHour12 () {

        if (this.period == null) {
            if (hours == 0)
                return String.format("%02d:%02d:%02d AM", hours + 12, minutes, seconds);
            if (hours >= 1 && hours <= 11)
                return String.format("%02d:%02d:%02d AM", hours, minutes, seconds);
            if (hours >= 13 && hours <= 23)
                return String.format("%02d:%02d:%02d PM", hours - 12, minutes, seconds);
            else
                return String.format("%02d:%02d:%02d PM", hours, minutes, seconds);
        }

        else
            return String.format("%02d:%02d:%02d %s", hours, minutes, seconds, period);
    }
    /**
     * Performs the equality tests of the current clock with another clock
     * passed as a parameter . Two clock are equal if they represent the same
     * instant regardless of being in 12h or 24h format .
     * @param o The clock to be compared with the current clock .
     * @return true if the clocks are equals , false otherwise .
     */
    @Override
    public boolean equals ( Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if(this.getClass() != o.getClass())
            return false;

        Clock otherClock = (Clock) o;
        if(this.getHours24() == otherClock.getHours24()) {
            if(this.getMinutes() == otherClock.getMinutes()){
                if(this.getSeconds() == otherClock.getSeconds()){
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Returns a integer that is a hash code representation of the clock using
     * the " hash 31" algorithm .
     * Clocks that are equals must have the same hash code .
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(getHours24(), minutes, seconds);
    }
}