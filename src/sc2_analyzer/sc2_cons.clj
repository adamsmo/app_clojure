(ns sc2-analyzer.sc2-cons)

;jednostki ze strony blizzarda
;var a = []
;$('.techtree-holder div.tt-outer.structure-name table tr td')
;.clone()
;.children()
;.remove()
;.end()
;.each(function( index ) {a.push($( this ).text())});
;"\""+a.join("\" \"") + "\""


;jednostki
;var a = {}
;$('.active .unit-datatable').each(function(){
; var race = $(this).find('.title-bar span').text()
;   var unit_details = []
;   $(this).find('.button-rollover').each(function(){
;      var unit = {};
;      unit['name'] = $(this).find('.unit-title span').text()
;          unit['mineral'] = Number($(this).find('.mineral').text())
;      unit['vespene'] = Number($(this).find('.vespene').text())
;          unit['supply'] = Number($(this).find('.supply').text())
;      unit['buildtime'] = Number($(this).find('.buildtime').text())
;          unit['life'] = Number($(this).find('.life').text())
;      unit['armor'] = Number($(this).find('.armor').text())
;          unit_details.push(unit)
;      })
;   a[race] = unit_details
; })

(def zerg-buildings
  '("Hatchery" "Extractor" "Evolution Chamber" "Spore Crawler" "Spine Crawler" "Spawning Pool" "Roach Warren"
     "Baneling Nest" "Nydus Network" "Lair" "Infestation Pit" "Spire" "Hydralisk Den" "Ultralisk Cavern" "Hive"
     "Greater Spire" "Lurker Den"))

(def protoss-buildings
  '("Nexus", "Pylon", "Assimilator", "Photon Cannon", "Cybernetics Core", "Stargate", "Fleet Beacon",
     "Robotics Facility", "Twilight Council", "Templar Archives", "Dark Shrine", "Robotics Bay", "Gateway",
     "Warp Gate", "Forge"))

(def terran-buoldings
  '("Command Center" "Supply Depot" "Refinery" "Engineering Bay" "Missile Turret" "Barracks" "Planetary Fortress"
     "Sensor Tower" "Bunker" "Factory" "Orbital Command" "Ghost Academy" "Armory" "Starport" "Fusion Core"
     "Tech Lab" "Reactor"))

(def terran-army
  '("Marine", "Marauder", "Reaper", "Ghost", "Hellion", "Siege Tank", "Thor", "Viking", "Medivac", "Raven",
     "Banshee", "Battlecruiser", "Hellbat", "Widow Mine", "Liberator", "Cyclone"))

(def protoss-army
  '("Zealot", "Stalker", "Sentry", "Observer", "Immortal", "Warp Prism", "Colossus", "Phoenix", "Void Ray",
     "High Templar", "Dark Templar", "Archon", "Carrier", "Mothership", "Mothership Core", "Oracle", "Tempest",
     "Adept", "Disruptor"))

(def zerg-army
  '("Overlord", "Zergling", "Queen", "Hydralisk", "Baneling", "Overseer", "Roach", "Infestor",
     "Mutalisk", "Corruptor", "Nydus Worm", "Ultralisk", "Brood Lord", "Swarm Host", "Viper", "Ravager", "Lurker"))

(def workers
  '("SCV" "Probe" "Drone"))

(def all-units
  (concat zerg-buildings terran-buoldings protoss-buildings terran-army zerg-army protoss-army workers))
