Sending Email with Attachment using Java Mail API
This Java program demonstrates how to send an email with an attachment using the Java Mail API.

Features:

Sends email from a Gmail account using Mailgun SMTP server.
Attaches a local XLS file to the email.
Requirements:

Java installed
JavaMail API library (https://www.oracle.com/java/technologies/javamail-api.html)
Instructions:

Replace the following placeholders with your information:
username: Your Mailgun account username (postmaster for sandbox accounts)
password: Your Mailgun account password
/Users/adityaanand/IdeaProjects/datamaticspdftoxls/AdityaPDFtoXLS.xls: Path to your XLS file
Compile and run the program using javac SendingEmail.java and java SendingEmail.
Explanation:

The code utilizes the Java Mail API to establish a connection with the Mailgun SMTP server and send an email. Here's a breakdown of the key steps:

Configuration:

Sets SMTP properties for authentication, TLS encryption, server address, and port.
Creates a session object using these properties and an authenticator for username and password.
Email Construction:

Creates a MimeMessage object representing the email.
Sets sender and recipient email addresses.
Sets the email subject.
Attachment:

Creates a MimeBodyPart to hold the attachment.
Creates a Multipart object to hold both the email body (if any) and the attachment.
Sets the data source for the attachment using the file path.
Sets the filename for the attachment.
Adds the MimeBodyPart containing the attachment to the Multipart.
Sets the message content to the Multipart object.
Sending Email:

Prints a message indicating the email is being sent with an attachment.
Uses Transport.send to send the email.
Prints a success message upon successful delivery.
Error Handling:

Catches any MessagingException that might occur during the process and prints the stack trace for debugging.
Note:

This is a basic example and might require adjustments based on your specific Mailgun account configuration and security settings. Refer to Mailgun's documentation for detailed instructions on using their SMTP server (https://documentation.mailgun.com/docs/mailgun/user-manual/sending-messages/).
