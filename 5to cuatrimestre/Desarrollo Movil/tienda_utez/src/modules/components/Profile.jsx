import React, { useState } from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { Icon, Avatar, Button } from "@rneui/base";
import { getAuth } from 'firebase/auth';
import AvatarComponent from './profile/AvatarComponent';
import ProfileOptions from './profile/ProfileOptions';

export default function Profile() {
    const auth = getAuth();
    const [user, setUser] = useState(auth.currentUser);

    return (
        <View style={styles.container}>
            <AvatarComponent />
            <ProfileOptions />
            <Button
                title={"Cerrar sesión"}
                containerStyle={styles.btnLogoutContainer}
                buttonStyle={styles.btnLogout}
                titleStyle={{ color: "white" }} // Cambiado a blanco
                onPress={() => {
                    auth.signOut();
                }}
            />
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: 'white',
        marginTop: 64
    },
    btnLogoutContainer: {
        marginTop: 16,
        marginHorizontal: 16,
        marginBottom: 32,
    },
    btnLogout: {
        backgroundColor: "#4abfa4", // Cambiado a verde
        borderColor: '#4abfa4',
        borderWidth: 1,
    }
});