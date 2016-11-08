package ua.training.block04.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p> The notebook's note class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 05.11.2016.
 */
public class Note {

    /**
     * Person's name
     */
    private String name;

    /**
     * Person's patronymic
     */
    private String patronymic;

    /**
     * Person's surname
     */
    private String surname;

    /**
     * Short interpretation of person's full name
     */
    private String shortName;

    /**
     * Person's nickname
     */
    private String nickname;

    /**
     * Some comment to the note
     */
    private String comment;

    /**
     * A group of notes that person belongs to
     */
    private Group group;

    /**
     * Person's home phone number
     */
    private String homeNumber;

    /**
     * First person's mobile phone number
     */
    private String mobileNumber1;

    /**
     * Second person's mobile phone number
     */
    private String mobileNumber2;

    /**
     * Person's e-mail
     */
    private String email;

    /**
     * Person's messenger nickname like Skype nickname
     */
    private String messenger;

    /**
     * Person's address
     */
    private Address address;

    /**
     * Person's address in one string interpretation
     */
    private String stringAddress;

    /**
     * Note creating time
     */
    private LocalDateTime createTime;

    /**
     * Note updating time
     */
    private LocalDateTime updateTime;

    public Note() {
        createTime = LocalDateTime.now();
    }

    // Generating the short interpretation of person's full name utilizing pattern ["surname" + first capital letter from the "name"]
    private String generateShortName() {
        StringBuilder shortName = new StringBuilder();
        if (surname == null) return null;
        shortName.append(surname);
        shortName.append(" ");
        if (name == null) return null;
        shortName.append(name.isEmpty() ? name : (name.charAt(0) + "."));
        return shortName.toString();
    }

    // Generating the string interpretation of address
    private String generateStringAddress() {
        if (address == null) return null;
        StringBuilder builder = new StringBuilder();
        builder.append(address.getBuilding()).append(" ");
        builder.append(address.getStreet()).append(" St., ");
        builder.append("apt ").append(address.getApartment()).append("; ");
        builder.append(address.getCity()).append(" ");
        builder.append(address.getZip());
        return builder.toString();
    }

    public String getName() {
        return name;
    }

    /**
     * This method sets person's name and updates {@link Note#updateTime} field
     *
     * @param name - person's name
     */
    public void setName(String name) {
        updateTime = LocalDateTime.now();
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    /**
     * This method sets person's patronymic and updates {@link Note#updateTime} field
     *
     * @param patronymic - person's patronymic
     */
    public void setPatronymic(String patronymic) {
        updateTime = LocalDateTime.now();
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    /**
     * This method sets person's surname and updates {@link Note#updateTime} field
     *
     * @param surname - person's surname
     */
    public void setSurname(String surname) {
        updateTime = LocalDateTime.now();
        this.surname = surname;
    }

    public String getShortName() {
        return shortName;
    }

    /**
     * This method directly sets short interpretation of person's full name and updates {@link Note#updateTime} field
     *
     * @param shortName - short interpretation of person's full name
     */
    public void setShortName(String shortName) {
        updateTime = LocalDateTime.now();
        this.shortName = shortName;
    }

    /**
     * This method build short name of person by the template: "surname" + first capital letter from the "name"
     * and sets it to the corresponding class field.
     * This method updates {@link Note#updateTime} field too
     */
    public void setShortName() {
        String newGeneratedShortName = generateShortName();
        if (newGeneratedShortName == null || newGeneratedShortName.equals(shortName)) return;
        updateTime = LocalDateTime.now();
        this.shortName = newGeneratedShortName;
    }

    public String getNickname() {
        return nickname;
    }

    /**
     * This method sets person's nickname and updates {@link Note#updateTime} field
     * @param nickname - person's nickname
     */
    public void setNickname(String nickname) {
        updateTime = LocalDateTime.now();
        this.nickname = nickname;
    }

    public String getComment() {
        return comment;
    }

    /**
     * This method sets some comment to the note and updates {@link Note#updateTime} field
     *
     * @param comment - commentary
     */
    public void setComment(String comment) {
        updateTime = LocalDateTime.now();
        this.comment = comment;
    }

    public Group getGroup() {
        return group;
    }

    /**
     * This method sets group of notes that person belongs to and updates {@link Note#updateTime} field
     *
     * @param group - group of notes
     */
    public void setGroup(Group group) {
        updateTime = LocalDateTime.now();
        this.group = group;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    /**
     * This method sets person's home phone number and updates {@link Note#updateTime} field
     *
     * @param homeNumber - person's home phone number
     */
    public void setHomeNumber(String homeNumber) {
        updateTime = LocalDateTime.now();
        this.homeNumber = homeNumber;
    }

    public String getMobileNumber1() {
        return mobileNumber1;
    }

    /**
     * This method sets first person's mobile phone number and updates {@link Note#updateTime} field
     *
     * @param mobileNumber1 - person's mobile phone number
     */
    public void setMobileNumber1(String mobileNumber1) {
        updateTime = LocalDateTime.now();
        this.mobileNumber1 = mobileNumber1;
    }

    public String getMobileNumber2() {
        return mobileNumber2;
    }

    /**
     * This method sets second person's mobile phone number and updates {@link Note#updateTime} field
     *
     * @param mobileNumber2 - person's mobile phone number
     */

    public void setMobileNumber2(String mobileNumber2) {
        updateTime = LocalDateTime.now();
        this.mobileNumber2 = mobileNumber2;
    }

    public String getEmail() {
        return email;
    }

    /**
     * This method sets person's email and updates {@link Note#updateTime} field
     *
     * @param email - person's email
     */
    public void setEmail(String email) {
        updateTime = LocalDateTime.now();
        this.email = email;
    }

    public String getMessenger() {
        return messenger;
    }

    /**
     * This method sets person's messenger nickname (like Skype) and updates {@link Note#updateTime} field
     *
     * @param messenger - person's messenger nickname
     */
    public void setMessenger(String messenger) {
        updateTime = LocalDateTime.now();
        this.messenger = messenger;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * This method sets person's address and updates {@link Note#updateTime} field
     *
     * @param address - person's address
     */
    public void setAddress(Address address) {
        updateTime = LocalDateTime.now();
        this.address = address;
    }

    public String getStringAddress() {
        return stringAddress;
    }

    /**
     * This method directly sets string interpretation of person's address and updates {@link Note#updateTime} field
     *
     * @param stringAddress - string interpretation of person's address
     */
    public void setStringAddress(String stringAddress) {
        updateTime = LocalDateTime.now();
        this.stringAddress = stringAddress;
    }

    /**
     * This method builds the line containing full person's address and sets it to the corresponding
     * class field.
     */
    public void setStringAddress() {
        String newGeneratedString = generateStringAddress();
        if (newGeneratedString == null || newGeneratedString.equals(stringAddress)) return;
        updateTime = LocalDateTime.now();
        this.stringAddress = generateStringAddress();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        return "Note{" +
                "name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", surname='" + surname + '\'' +
                ", shortName='" + shortName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", comment='" + comment + '\'' +
                ", group='" + group.name() + '\'' +
                ", homeNumber='" + homeNumber + '\'' +
                ", mobileNumber1='" + mobileNumber1 + '\'' +
                ", mobileNumber2='" + mobileNumber2 + '\'' +
                ", email='" + email + '\'' +
                ", messenger='" + messenger + '\'' +
                ", address=" + address.toString() +
                ", string address='" + stringAddress + '\'' +
                ", createTime=" + createTime.format(formatter) +
                ", updateTime=" + updateTime.format(formatter) +
                '}';
    }
}
