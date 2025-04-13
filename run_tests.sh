#!/bin/bash

# Set environment variables for locators
export homepage_AddNote_button="//button[contains(text(),'Add Note')]"
export myNotes_titlefield="//input[@id='note-title']"
export myNotes_notebodyfield="//textarea[@id='note-body']"
export myNotes_addNoteButton="//button[contains(text(),'Save Note')]"
export myNotes_thirdNote="//div[@class='note'][3]//h3"
export myNotes_thirdNoteBody="//div[@class='note'][3]//p"
export loginpage_user="//input[@id='username']"
export loginpage_password="//input[@id='password']"
export loginpage_loginbutton="//button[contains(text(),'Login')]"
export loginpage_accept_button="//button[contains(text(),'Accept')]"
export loginpage_error_message="//div[@class='error-message']"
export mynotes_container="//div[@class='notes-container']"

# Run the tests
mvn clean test -Dgauge.specsDir=specs -Dgauge.env=default 