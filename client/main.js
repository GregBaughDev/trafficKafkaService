const { app, BrowserWindow } = require('electron')

const createWindow = () => {
  const win = new BrowserWindow({
    width: 1000,
    height: 800,
    resizable: false
  })

  win.loadFile('index.html')
}

app.whenReady().then(() => {
  createWindow()
})