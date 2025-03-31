import { StyleSheet, Text, View, FlatList } from 'react-native';
import { Card, Image } from "@rneui/base";
import React, { useEffect, useState } from 'react';
import { getFirestore, collection, getDocs } from 'firebase/firestore';
import { app } from '../../config/firebaseConnection'; 

const db = getFirestore(app);

export default function Home() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const productsList = [];
        const querySnapshot = await getDocs(collection(db, 'products'));
        querySnapshot.forEach(documentSnapshot => {
          productsList.push({ ...documentSnapshot.data(), id: documentSnapshot.id });
        });
        setProducts(productsList);
      } catch (error) {
        console.error("Error fetching products: ", error);
      }
    };

    fetchProducts();
  }, []);

  const renderItem = ({ item }) => (
    <Card containerStyle={styles.card}>
      <Image
        source={{ uri: item.image ? item.image : "https://via.placeholder.com/150" }}
        style={styles.image}
      />
      <Text style={styles.name}>{item.name}</Text>
      <View style={styles.row}>
        <Text style={styles.price}>{item.price ? `$${item.price}` : "Precio no disponible"}</Text>
        <Text style={styles.stock}>{item.stock ? `Stock: ${item.stock}` : "Sin stock"}</Text>
      </View>
    </Card>
  );

  return (
    <FlatList
      data={products}
      renderItem={renderItem}
      keyExtractor={(item) => item.id}
      numColumns={2}
      columnWrapperStyle={styles.row}
      ListEmptyComponent={<Text>Loading...</Text>}
    />
  );
}

const styles = StyleSheet.create({
  row: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    marginTop: 10,
  },
  card: {
    flex: 1,
    margin: 5,
    padding: 10,
  },
  image: {
    width: '100%',
    height: 150,
    resizeMode: 'cover',
  },
  name: {
    fontSize: 16,
    fontWeight: 'bold',
    marginVertical: 10,
  },
  price: {
    fontSize: 14,
    fontWeight: 'bold',
    color: '#4abfa4',
  },
  stock: {
    fontSize: 14,
    color: 'gray',
  },
});