const trafficDiv = document.getElementById('traffic-div')
const modal = document.getElementById('modal')
const closeModalLink = document.getElementById('close-modal')

const trafficContainer = (info, parentElem) => {
  const parent = document.createElement("div")
  const leftDiv = document.createElement("div")
  const h3 = document.createElement("h3")
  const h4 = document.createElement("h4")
  const h5 = document.createElement("h5")
  const startDate = document.createElement("p")
  const endDate = document.createElement("p")

  parent.className = "container"

  h3.textContent = `Road: ${info.closedRoadName}`
  h4.textContent = `Intersection road name: ${info.intersectionRoadName}`
  h5.textContent = `Area: ${info.localGovernmentArea}`
  startDate.textContent = `Start: ${info.start}`
  endDate.textContent = `End: ${info.end}`

  const rightDiv = document.createElement("div")
  const moreInfo = document.createElement("a")
  moreInfo.textContent = "More Info"
  moreInfo.addEventListener('click', () => {
    populateModal(info)
    trafficDiv.classList.add('hide')
    modal.classList.remove('hide')
    modal.classList.add('modal')
  })

  rightDiv.append(moreInfo)
  leftDiv.append(h3)
  leftDiv.append(h4)
  leftDiv.append(h5)
  leftDiv.append(startDate)
  leftDiv.append(endDate)
  parent.append(leftDiv)
  parent.append(rightDiv)
  parentElem.append(parent)
}

const populateModal = (info) => {
  document.getElementById('closedRoad').textContent = `Closed road: ${info.closedRoadName}`
  document.getElementById('intersectionStart').textContent = `Intersection: ${info.intersectionRoadName}`
  document.getElementById('govtArea').textContent = `Area: ${info.localGovernmentArea}`
  document.getElementById('evtType').textContent = `Event type: ${info.eventType}`
  document.getElementById('evtDueTo').textContent = `Event due to: ${info.eventDueTo}`
  document.getElementById('direction').textContent = `Direction: ${info.direction}`
  document.getElementById('impact').textContent = `Impact: ${info.impact}`
  document.getElementById('delay').textContent = `Delay: ${info.delay}`
  document.getElementById('speedLimit').textContent = `Speed limit: ${info.speedLimit}-Km`
  document.getElementById('start').textContent = `Start: ${info.start}`
  document.getElementById('end').textContent = `End: ${info.end}`
  document.getElementById('description').textContent = `Description: ${info.description}`
}

closeModalLink.addEventListener('click', () => {
  trafficDiv.classList.remove('hide')
  modal.classList.add('hide')
  modal.classList.remove('modal')
})

const getDataAndDisplay = async () => {
  const trafficInfoData = await fetch('http://localhost:8585/traffic-info')
  const result = await trafficInfoData.json()
  result.result.map((elem) => trafficContainer(JSON.parse(elem), trafficDiv))
}

getDataAndDisplay()