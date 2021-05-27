package com.timlai.stockapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalTime;

//This represents the User's chosen preferences after the User has made an account. This will be stored in the database.

@Data
@Entity
public class UserPreferences {
    @Id
    private String userId; //This is an ID that the user has chosen to use to log in to the app.
                            // This is from the User Object.

    private NotificationPreference notificationPreference; //This is the notifications that a user has selected - Email or text.
    private LocalTime notificationTime; //This is the time that a user chooses to be notified.
}
