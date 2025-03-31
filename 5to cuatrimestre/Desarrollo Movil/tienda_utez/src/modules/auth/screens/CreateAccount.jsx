import React, { useState } from "react";
import { View, StyleSheet, Alert } from "react-native";
import { Card } from '@rneui/themed';
import { Input, Button, Icon } from "@rneui/themed";
import { isEmpty } from "lodash";
import { createUserWithEmailAndPassword } from "firebase/auth";
import { auth } from "../../../config/firebaseConnection";

export default function CreateAccount({ navigation }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirm, setConfirm] = useState("");
  const [error, setError] = useState({ email: "", password: "", confirm: "" });
  const [showPassword, setShowPassword] = useState(true);

  const handleCreate = () => {
    setError({ email: "", password: "", confirm: "" });

    if (isEmpty(email) || isEmpty(password) || isEmpty(confirm)) {
      setError({
        email: isEmpty(email) ? "El correo electrónico es requerido" : "",
        password: isEmpty(password) ? "La contraseña es requerida" : "",
        confirm: isEmpty(confirm) ? "La confirmación es requerida" : "",
      });
      return;
    }

    if (password !== confirm) {
      setError({
        password: "Las contraseñas no coinciden",
        confirm: "Las contraseñas no coinciden",
      });
      return;
    }

    createUserWithEmailAndPassword(auth, email, password)
      .then((userCredential) => {
        Alert.alert("Éxito", "Cuenta creada correctamente");
        navigation.goBack();
      })
      .catch((error) => {
        Alert.alert("Error", error.message);
      });
  };

    return (
        <View style={styles.container}>
          <Card containerStyle={styles.card}>
            <Icon
              name="user-plus"
              type="font-awesome"
              size={58}
              containerStyle={styles.icon}
            />
            <Card.Divider />
            <Input
              placeholder="Correo electrónico"
              keyboardType="email-address"
              value={email}
              onChangeText={setEmail}
              autoCapitalize="none"
              errorMessage={error.email}
            />
            <Input
              placeholder="Contraseña"
              value={password}
              onChangeText={setPassword}
              secureTextEntry={showPassword}
              errorMessage={error.password}
              rightIcon={
                <Icon
                  onPress={() => setShowPassword(!showPassword)}
                  type="material-community"
                  name={showPassword ? "eye-outline" : "eye-off-outline"}
                />
              }
            />
            <Input
              placeholder="Confirmar contraseña"
              value={confirm}
              onChangeText={setConfirm}
              secureTextEntry={showPassword}
              errorMessage={error.confirm}
              rightIcon={
                <Icon
                  onPress={() => setShowPassword(!showPassword)}
                  type="material-community"
                  name={showPassword ? "eye-outline" : "eye-off-outline"}
                />
              }
            />
            <Button
              title="Crear Cuenta"
              onPress={handleCreate}
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
      title: {
        marginBottom: 10,
      },
      button: {
        marginTop: 10,
      },
    });