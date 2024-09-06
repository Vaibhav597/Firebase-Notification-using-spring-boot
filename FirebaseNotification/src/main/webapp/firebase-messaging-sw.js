// Import Firebase scripts
importScripts('https://www.gstatic.com/firebasejs/9.1.3/firebase-app-compat.js');
importScripts('https://www.gstatic.com/firebasejs/9.1.3/firebase-messaging-compat.js');

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyCGPaX5lYlbMPM_pjHmwSJPfB6SdFRLGSY",
  authDomain: "fir-notification1-63f63.firebaseapp.com",
  projectId: "fir-notification1-63f63",
  storageBucket: "fir-notification1-63f63.appspot.com",
  messagingSenderId: "390995295455",
  appId: "1:390995295455:web:ca3aeffa89af05f0a6bd6a"
};

// Initialize Firebase
firebase.initializeApp(firebaseConfig);

const messaging = firebase.messaging();

messaging.onBackgroundMessage((payload) => {
  console.log('[firebase-messaging-sw.js] Received background message', payload);
  const notificationTitle = payload.notification.title;
  const notificationOptions = {
    body: payload.notification.body,
    icon: 'https://freepnglogo.com/images/all_img/facebook-logo.png'
  };

  self.registration.showNotification(notificationTitle, notificationOptions);
});
