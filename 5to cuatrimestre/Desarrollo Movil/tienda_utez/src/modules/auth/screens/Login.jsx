import React, { useState } from "react";
import { View, StyleSheet, Alert } from "react-native";
import { Card } from '@rneui/themed';
import { Input, Button, Icon } from "@rneui/themed";
import { isEmpty } from "lodash";
import { signInWithEmailAndPassword } from "firebase/auth";
import { auth } from "../../../config/firebaseConnection";

export default function Login({navigation }) {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState({ email: "", password: "" });
    const [submitted, setSubmitted] = useState(false);
    const [showPassword, setShowPassword] = useState(true);
  
    const handleLogin = () => {
      setSubmitted(true);
      let valid = true;
      let newError = { email: "", password: "" };
  
      if (isEmpty(email)) {
        newError.email = "El correo electrónico es requerido";
        valid = false;
      }
      if (isEmpty(password)) {
        newError.password = "La contraseña es requerida";
        valid = false;
      }
      setError(newError);
  
      if (!valid) {
        return;
      }
  
      signInWithEmailAndPassword(auth, email, password)
        .catch((error) => {
          Alert.alert("Error de Autenticación", error.message);
        });
    };
  
    return (
      <View style={styles.container}>
        <Card containerStyle={styles.card}>
          <Icon
            name="user"
            type="font-awesome"
            size={58}
            containerStyle={styles.icon}
          />
          <Card.Divider />
          <Input
            placeholder="Correo electrónico"
            label="Correo electrónico"
            autoCapitalize="none"
            keyboardType="email-address"
            value={email}
            onChangeText={(text) => {
              setEmail(text);
              if (submitted && isEmpty(text)) {
                setError((prev) => ({ ...prev, email: "El correo electrónico es requerido" }));
              } else {
                setError((prev) => ({ ...prev, email: "" }));
              }
            }}
            errorMessage={submitted && error.email ? error.email : ""}
            inputContainerStyle={{ width: "100%" }}
          />
          <Input
            placeholder="Contraseña"
            label="Contraseña"
            secureTextEntry={showPassword}
            value={password}
            onChangeText={(text) => {
              setPassword(text);
              if (submitted && isEmpty(text)) {
                setError((prev) => ({ ...prev, password: "La contraseña es requerida" }));
              } else {
                setError((prev) => ({ ...prev, password: "" }));
              }
            }}
            errorMessage={submitted && error.password ? error.password : ""}
            rightIcon={
              <Icon
                onPress={() => setShowPassword(!showPassword)}
                type="material-community"
                name={showPassword ? "eye-outline" : "eye-off-outline"}
              />
            }
            inputContainerStyle={{ width: "100%" }}
          />
          <Button
            title="Iniciar Sesión"
            onPress={handleLogin}
            containerStyle={styles.button}
          />
          <Button
            title="Crear Cuenta"
            type="outline"
            onPress={() => navigation.navigate("Registro")}
            containerStyle={styles.button}
          />
        </Card>
      </View>
    );
  }
  
  const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: "#f2f2f2",
      justifyContent: "center",
      alignItems: "center",
    },
    card: {
      width: "90%",
      borderRadius: 10,
    },
    icon: {
      alignSelf: "center",
      marginBottom: 10,
    },
    button: {
      marginTop: 10
    },
  });