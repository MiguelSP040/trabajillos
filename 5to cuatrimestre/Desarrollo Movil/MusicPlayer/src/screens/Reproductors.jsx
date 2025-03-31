import React from "react";
import { View, Text, Image, ImageBackground, StyleSheet } from "react-native";
import { Icon } from "@rneui/themed";

export default function Reproductor({ route }) {
  const { song } = route.params;

  return (
    <View style={styles.playerContainer}>
      <View style={styles.topIconsContainer}>
        <Icon name="chevron-down" type="font-awesome" color="white" />
        <Text style={styles.title}>THE WEEKEND PLAYLIST</Text>
        <View style={styles.rightIcons}>
          <Icon name="ellipsis-v" type="font-awesome" color="white" />
        </View>
      </View>
      <ImageBackground source={song.cover} style={styles.backgroundImage} imageStyle={{ opacity: 0.3 }}>
        <Image source={song.cover} style={styles.playerCover} />
      </ImageBackground>
      <Text style={styles.playerTitle}>{song.title}</Text>
      <Text style={styles.playerArtist}>{song.artist}</Text>
      <View style={styles.progressContainer}>
        <Text style={styles.progressTime}>0:00</Text>
        <View style={styles.progressBar}>
          <View style={styles.progress} />
        </View>
        <Text style={styles.progressTime}>3:45</Text>
      </View>
      <View style={styles.controls}>
        <Icon name="backward" type="font-awesome" size={30} color="white" />
        <Icon name="play" type="font-awesome" size={40} color="white" />
        <Icon name="forward" type="font-awesome" size={30} color="white" />
      </View>
      <View style={styles.bottomIconsContainer}>
        <Icon name="volume-up" type="font-awesome" size={30} color="white" />
        <Icon name="repeat" type="font-awesome" size={30} color="white" />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  playerContainer: { flex: 1, backgroundColor: "#000", alignItems: "center", justifyContent: "center", height: "100%" },
  topIconsContainer: { flexDirection: "row", justifyContent: "space-between", width: "100%", paddingHorizontal: 20, marginTop: -150 },
  title: { fontSize: 20, color: "white", marginLeft: -15, fontWeight: "bold" },
  rightIcons: { flexDirection: "row", justifyContent: "space-between" },
  backgroundImage: { width: "100%", alignItems: "center", justifyContent: "center", marginBottom: 20, height: 400 },
  playerCover: { width: 200, height: 200, borderRadius: 10 },
  playerTitle: { fontSize: 24, fontWeight: "bold", color: "white", marginTop: 10 },
  playerArtist: { fontSize: 18, color: "gray" },
  progressContainer: { flexDirection: "row", alignItems: "center", width: "80%", marginTop: 10 },
  progressTime: { color: "white", fontSize: 14 },
  progressBar: { flex: 1, height: 4, backgroundColor: "gray", marginHorizontal: 10, borderRadius: 2 },
  progress: { width: "30%", height: "100%", backgroundColor: "white", borderRadius: 2 },
  controls: { flexDirection: "row", justifyContent: "space-around", width: "80%", marginTop: 20 },
  bottomIconsContainer: { flexDirection: "row", justifyContent: "space-between", width: "100%", paddingHorizontal: 20, position: "absolute", bottom: 20 },
  lyricsButton: { backgroundColor: "#1DB954", marginTop: 20, borderRadius: 10 },
});