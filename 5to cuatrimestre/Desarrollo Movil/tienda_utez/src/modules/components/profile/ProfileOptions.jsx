import React from "react";
import { View, StyleSheet, FlatList } from "react-native";
import { ListItem, Icon } from "@rneui/themed";

const list1 = [
  { title: "Modificar nombre", icon: "account-outline" },
  { title: "Cambiar contraseña", icon: "lock-outline" },
  { title: "Cambiar correo", icon: "email-outline" },
];

export default function ProfileOptions  () {
  const renderItem = ({ item }) => (
    <ListItem bottomDivider onPress={() => console.log(item.title)}>
      <Icon name={item.icon} type="material-community" />
      <ListItem.Content>
        <ListItem.Title>{item.title}</ListItem.Title>
      </ListItem.Content>
      <ListItem.Chevron />
    </ListItem>
  );

  return (
    <View style={styles.container}>
      <FlatList
        data={list1}
        keyExtractor={(item, index) => index.toString()}
        renderItem={renderItem}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "white",
  },
});
