import React, { useState, useEffect } from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { Icon } from "@rneui/base";
import { getAuth, onAuthStateChanged } from "firebase/auth";
import Login from "./src/modules/auth/screens/Login";
import CreateAccount from "./src/modules/auth/screens/CreateAccount";
import Home from "./src/modules/components/Home";
import Profile from "./src/modules/components/Profile";

const Stack = createStackNavigator();
const Tab = createBottomTabNavigator();

function AuthStack() {
  return (
    <Stack.Navigator initialRouteName="Login" screenOptions={{ headerShown: false }}>
      <Stack.Screen name="Login" component={Login} />
      <Stack.Screen name="Registro" component={CreateAccount} />
    </Stack.Navigator>
  );
}

function MainTabs() {
  return (
    <Tab.Navigator
      screenOptions={({ route }) => ({
        tabBarIcon: ({ focused, color, size }) => {
          const { iconName, iconType } = getIconName(route.name, focused);
          return <Icon name={iconName} type={iconType} size={size} color={color} />;
        },
        tabBarActiveTintColor: "#4abfa4",
        tabBarInactiveTintColor: "gray",
        headerShown: true,
      })}
    >
      <Tab.Screen name="Home" component={Home} options={{ title: "Inicio" }} />
      <Tab.Screen name="Profile" component={Profile} options={{ title: "Perfil" }} />
    </Tab.Navigator>
  );
}

export default function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const auth = getAuth();

  useEffect(() => {
    const unsubscribe = onAuthStateChanged(auth, (user) => {
      setIsAuthenticated(!!user);
    });
    return unsubscribe;
  }, []);

  return (
    <NavigationContainer>
      {isAuthenticated ? <MainTabs /> : <AuthStack />}
    </NavigationContainer>
  );
}

const getIconName = (routeName, focused) => {
  let iconName = "";
  const iconType = "material-community";
  switch (routeName) {
    case "Home":
      iconName = focused ? "home" : "home-outline";
      break;
    case "Profile":
      iconName = focused ? "account" : "account-outline";
      break;
  }
  return { iconName, iconType };
};
