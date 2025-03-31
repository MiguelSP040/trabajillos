import React from "react";
import { View, Text, FlatList, Image, TouchableOpacity, StyleSheet } from "react-native";
import { Card, Icon } from "@rneui/themed";
import PagerView from 'react-native-pager-view';
import { map } from 'lodash';

const songs = [
  { id: "1", title: "STARBOY", artist: "The Weeknd", cover: require("../../assets/starboy.jpeg") },
  { id: "2", title: "AFTER HOURS", artist: "The Weeknd", cover: require("../../assets/afterhours.jpeg") },
  { id: "3", title: "A LONELY NIGHT", artist: "The Weeknd", cover: require("../../assets/lonelynight.jpeg") },
  { id: "4", title: "REMINDER", artist: "The Weeknd", cover: require("../../assets/reminder.jpeg") },
  { id: "5", title: "FALSE ALARM", artist: "The Weeknd", cover: require("../../assets/falsealarm.jpeg") }
];

export default function Listado({ navigation }) {
  return (
    <View style={styles.container}>
      <PagerView style={styles.playlistCover} initialPage={0}>
        {songs.map((song, index) => (
          <View style={styles.playlistCover} key={index}>
            <Image source={song.cover} style={{ width: '100%', height: '100%' }} resizeMode='cover' />
          </View>
        ))}
      </PagerView>
      <Text style={styles.title}>WEEKEND PLAYLIST</Text>
      <View style={styles.info}>
        <View style={styles.info}>
          <Icon name="heart" type="font-awesome" color="gray" />
          <Text style={styles.content}>25.0 M</Text>
        </View>
        <View style={styles.info}>
          <Icon name="clock-o" type="font-awesome" color="gray" />
          <Text style={styles.content}>2h 25mins</Text>
        </View>
        <Icon name="play-circle" type="font-awesome" color="green" size={80} />
      </View>
      <FlatList
        data={songs}
        keyExtractor={(item) => item.id}
        renderItem={({ item }) => (
          <Card containerStyle={styles.card}>
            <TouchableOpacity onPress={() => navigation.navigate("Player", { song: item })}>
              <View style={styles.songItem}>
                <Image source={item.cover} style={styles.songCover} />
                <View style={styles.songInfo}>
                  <Text style={styles.songTitle}>{item.title}</Text>
                  <Text style={styles.songArtist}>{item.artist}</Text>
                </View>
                <Icon name="heart" type="font-awesome" color="gray" style={styles.icon} />
                <Icon name="ellipsis-v" type="font-awesome" color="gray" />
              </View>
            </TouchableOpacity>
          </Card>
        )}
        ItemSeparatorComponent={() => <View style={styles.separator} />}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: "#000", padding: 10 },
  playlistCover: { width: "100%", height: 250, borderRadius: 10, marginBottom: -74 },
  title: { fontSize: 32, fontWeight: "bold", color: "white", marginLeft: 10, marginBottom: -20 },
  info: { flexDirection: 'row', alignItems: 'center', marginHorizontal: 18 },
  content: { color: 'white', opacity: 0.5, marginHorizontal: 10 },
  card: { backgroundColor: "#000", borderRadius: 10, padding: 10, borderWidth: 0, shadowColor: "transparent" },
  songItem: { flexDirection: "row", alignItems: "center" },
  songCover: { width: 60, height: 60, borderRadius: 10 },
  songInfo: { flex: 1, marginLeft: 10 },
  songTitle: { fontSize: 18, fontWeight: "bold", color: "white" },
  songArtist: { fontSize: 14, color: "gray" },
  icon: { marginHorizontal: 10 },
  separator: { height: 1, backgroundColor: "gray", opacity: 0.5, marginTop: 14 }
});