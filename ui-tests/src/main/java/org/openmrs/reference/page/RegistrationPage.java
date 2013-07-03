package org.openmrs.reference.page;

import org.openmrs.reference.helper.PatientGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends AbstractBasePage {


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    private String DEMOGRAPHICS_SPAN = "//ul[@id='formBreadcrumb']/li[1]/span";
    private String CONTACT_INFO_SPAN = "//ul[@id='formBreadcrumb']/li[2]/span";
    private String CONFIRM_SPAN = "//ul[@id='formBreadcrumb']/li[3]/span";
    private String NAME_LINK = "ul#formBreadcrumb li:nth-of-type(1) li:nth-of-type(1)";
    private String GENDER_LINK = "ul#formBreadcrumb li:nth-of-type(1) li:nth-of-type(2)";
    private String DATE_PICKER = "span.date i.icon-calendar";
    private String DATE_WIDGET_ELEMENT = "div.datetimepicker-days tbody tr:nth-child(1) td";
    private String BIRTHDATE_LINK = "ul#formBreadcrumb li:nth-of-type(1) li:nth-of-type(3)";
    private String ADDRESS_LINK = "ul#formBreadcrumb li:nth-of-type(2) li:nth-of-type(2)";
    private String PHONE_NUMBER_LINK = "ul#formBreadcrumb li:nth-of-type(2) li:nth-of-type(1)";

    private String GivenName_TxtBox = "givenName";
    private String FamilyName_TxtBox = "familyName";
    private String Gender = "input[value='XX']";
    private String Address1_TxtBox = "address1";
    private String Address2_TxtBox = "address2";
    private String CityVillage_TxtBox = "cityVillage";
    private String State_TxtBox = "stateProvince";
    private String Country_TxtBox = "country";
    private String PostalCode_TxtBox = "postalCode";
    private String Latitude_TxtBox = "latitude";
    private String Longitude_TxtBox = "longitude";
    private String StartDate_TxtBox = "startDate";
    private String EndDate_TxtBox = "endDate";
    private String PhoneNumber_TxtBox = "phoneNumber";
    private String AddressInConfirmationPage = "//div[@id='dataCanvas']//li[5]/strong";


    public void clickOnDemographics() {
        clickOn(By.xpath(DEMOGRAPHICS_SPAN));
    }

    public void registerPatient(){
        enterPatientGivenName();
        enterPatientFamilyName();
        clickOnGenderLink();
        selectPatientGender();

        clickOnBirthDateLink();
        selectPatientBirthDate();

        clickOnContactInfo();
        clickOnAddressLink();
        enterPatientAddress();

        clickOnPhoneNumber();
        setTextToField(By.name(PhoneNumber_TxtBox), PatientGenerator.getPhoneNumber());
//
//        clickOnConfirm();
    }

    public void enterPatientAddress() {
        setTextToField(By.id(Address1_TxtBox), PatientGenerator.getPatientAddress1());
        setTextToField(By.id(Address2_TxtBox), PatientGenerator.getPatientAddress2());
        setTextToField(By.id(CityVillage_TxtBox), PatientGenerator.getPatientCity());
        setTextToField(By.id(State_TxtBox), PatientGenerator.getPatientState());
        setTextToField(By.id(Country_TxtBox),PatientGenerator.getPatientCountry());
        setTextToField(By.id(PostalCode_TxtBox),"345234");

        setTextToField(By.id(Latitude_TxtBox),"12");
        setTextToField(By.id(Longitude_TxtBox),"47");

        setTextToField(By.id(StartDate_TxtBox),"01-01-2000");
        setTextToField(By.id(EndDate_TxtBox),"01-01-2010");
    }

    public void selectPatientBirthDate() {
        clickOn(By.cssSelector(DATE_PICKER));
        clickOn(By.cssSelector(DATE_WIDGET_ELEMENT));
    }

    public void selectPatientGender() {
        clickOn(By.cssSelector(Gender.replace("XX", PatientGenerator.getPatientGender())));
    }

    public void enterPatientFamilyName() {
        setTextToField(By.name(FamilyName_TxtBox), PatientGenerator.getPatientFamilyName());
    }

    public void enterPatientGivenName() {
        setTextToField(By.name(GivenName_TxtBox), PatientGenerator.getPatientGivenName());
    }

    public void enterPatientGivenNameForAutoSuggestFn(String name){
        setTextToField(By.name(GivenName_TxtBox),name);
    }
    public void enterPatientFamilyNameForAutoSuggestFn(String name){
        setTextToField(By.name(FamilyName_TxtBox),name);
    }

    public void clickOnContactInfo(){
        clickOn(By.xpath(CONTACT_INFO_SPAN));
    }

    public void clickOnPhoneNumber() {
        clickOn(By.xpath(PHONE_NUMBER_LINK));
    }

    public void clickOnConfirm() {
        clickOn(By.xpath(CONFIRM_SPAN));
    }

    public void clickOnNameLink(){
        clickOn(By.cssSelector(NAME_LINK));
    }

    public void clickOnGenderLink(){
        clickOn(By.cssSelector(GENDER_LINK));
    }

    public void clickOnBirthDateLink(){
        clickOn(By.cssSelector(BIRTHDATE_LINK));
    }

    public void clickOnAddressLink(){
        clickOn(By.cssSelector(ADDRESS_LINK));
    }


    public String getAddressValueInConfirmationPage() {
        return  getText(By.xpath(AddressInConfirmationPage)) ;
    }

	@Override
    public String expectedUrlPath() {
	    return "/openmrs/registrationapp/registerPatient.page?appId=referenceapplication.registrationapp.registerPatient";
    }


}