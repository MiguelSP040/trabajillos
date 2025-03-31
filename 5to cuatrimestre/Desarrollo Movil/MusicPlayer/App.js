import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import Listado from "./src/screens/Listado";
import Reproductor from "./src/screens/Reproductors";

const Stack = createStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator screenOptions={{ headerShown: false }}>
        <Stack.Screen name="Playlist" component={Listado} />
        <Stack.Screen name="Player" component={Reproductor} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
