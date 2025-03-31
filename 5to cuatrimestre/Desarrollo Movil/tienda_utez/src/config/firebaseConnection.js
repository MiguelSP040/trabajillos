import { initializeApp } from "firebase/app";
import { initializeAuth, getReactNativePersistence } from "firebase/auth";
import ReactNativeAsyncStorage from "@react-native-async-storage/async-storage";
import { getFirestore } from "firebase/firestore";
import { getStorage } from "firebase/storage";
const firebaseConfig = {
    apiKey: "AIzaSyBojQ-1eGT1CKhqWmGufHVypbrNg1Eu5wE",
    authDomain: "tienda-utez-feff2.firebaseapp.com",
    projectId: "tienda-utez-feff2",
    storageBucket: "tienda-utez-feff2.firebasestorage.app",
    messagingSenderId: "1054424528711",
    appId: "1:1054424528711:web:7c6eeee3167df115a63e62"
};
const app = initializeApp(firebaseConfig);
const auth = initializeAuth(app, {
  persistence: getReactNativePersistence(ReactNativeAsyncStorage),
});
const db = getFirestore(app);
const storage = getStorage(app);
export { app, auth, db, storage };