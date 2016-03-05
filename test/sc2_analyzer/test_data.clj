(ns sc2-analyzer.test-data)

(def test-lines
  [" {'_bits': 160,"
   " '_event': 'NNet.Replay.Tracker.SPlayerSetupEvent',"
   " '_eventid': 9,"
   " '_gameloop': 0,"
   " 'm_playerId': 0,"
   " 'm_slotId': None,"
   " 'm_type': 3,"
   " 'm_userId': None}"
   " {'_bits': 192,"
   " '_event': 'NNet.Replay.Tracker.SPlayerSetupEvent',"
   " '_eventid': 9,"
   " '_gameloop': 0,"
   " 'm_playerId': 1,"
   " 'm_slotId': 0,"
   " 'm_type': 1,"
   " 'm_userId': 0}"])

(def for-clean
  ["{'m_cacheHandles': ['s2ma\\x00\\x00USm\\xe4\\x15\\x03\\xba\\xcc\\xd0VV6\\x0bo\\x02}\\xb8\\x81i\\xfa\\x19\\x89\\xbbcW\\xb1\\xb2\\x15\\xa2Ty9\\xf5\\xfb',"
   "'s2ma\\x00\\x00USB\\x1c\\x8a\\xa0\\xf3a\\x9be-#\\xa2s]\\xfe\\xe8\\x12\\xabdB(#^zy~\\xde\\xcf\\xe8\\xb6}\\xa3\\x0e',"
   "'s2ma\\x00\\x00USf\\t82\\x12\\x84S\\xef\\xff\\xbbx|\\x80\\xb7\\xd3\\xee\\xc1\\xad\\x81\\xbd\\xe5\\\\\\x83\\xc90\\xde\\xa7\\x9cNPZ\\x04',"
   "'s2ma\\x00\\x00USW\\xb4\\xac\\x0b=\\xda\\xd0T\\xba\\xdf\\x85\\xa9LfnW\\xe4v\\x9d\\x08x\\xca\\x96r\\x07\\x9e\\xc96\\xb8\\x0b\\x98\\xdc',"
   "'s2ma\\x00\\x00US\\x7fAA\\x1a\\xa5\\x97\\xf4\\xb4d@\\xd4*V3H\\xbfS\\x82-*h\\x11/\\x01\\x04\\xf9\\xb8\\x91\\xf6\\xf0Z\\xe1',"
   "'s2ma\\x00\\x00US\\xfb\\xc9j\\x8d\\xa9u-\\x06\\x04\\x9d\\xda!\\xe2\\x12Y\\x15\\xa7R\\x7f\\xbd9{\\x90\\x07\\xc2\\x8ej\\rO7#q'],"
   "'m_toon': {'m_id': 4263849, 'm_programId': '\\x00\\x00S2', 'm_realm': 1, 'm_region': 1}}"])

(def cleaned-data
  ["{'m_cacheHandles': ['s2ma'," "'s2ma',"
   "'s2max00x00USft82x12x84Sxefxffxbbx|x80xb7xd3xeexc1xadx81xbdxe5x83xc90xdexa7x9cNPZx04',"
   "'s2max00x00USWxb4xacx0b=xdaxd0Txbaxdfx85xa9LfnWxe4vx9dx08xxcax96rx07x9exc96xb8x0bx98xdc',"
   "'s2max00x00USx7fAAx1axa5x97xf4xb4d@xd4*V3HxbfSx82-*hx11/x01x04xf9xb8x91xf6xf0Zxe1',"
   "'s2ma'],"
   "'m_toon': {'m_id': 4263849, 'm_programId': 'x00x00S2', 'm_realm': 1, 'm_region': 1}}"])

(def example-details
  ["{'m_cacheHandles': ['s2ma\\x00\\x00EUm\\xe4\\x15\\x03\\xba\\xcc\\xd0VV6\\x0bo\\x02}\\xb8\\x81i\\xfa\\x19\\x89\\xbbcW\\xb1\\xb2\\x15\\xa2Ty9\\xf5\\xfb',"
   "                    's2ma\\x00\\x00EUB\\x1c\\x8a\\xa0\\xf3a\\x9be-#\\xa2s]\\xfe\\xe8\\x12\\xabdB(#^zy~\\xde\\xcf\\xe8\\xb6}\\xa3\\x0e',"
   "                    's2ma\\x00\\x00EUf\\t82\\x12\\x84S\\xef\\xff\\xbbx|\\x80\\xb7\\xd3\\xee\\xc1\\xad\\x81\\xbd\\xe5\\\\\\x83\\xc90\\xde\\xa7\\x9cNPZ\\x04',"
   "                    \"s2ma\\x00\\x00EU\\xd9-\\xfcH\\xc4\\x84\\xc5\\x91T'\\x0b\\x92J\\xd7\\xd5t\\x84\\xf2\\xab\\x9aGb\\x1cz\\xb1d1\\xbff\\xc5;@\","
   "                    's2ma\\x00\\x00EUW\\xb4\\xac\\x0b=\\xda\\xd0T\\xba\\xdf\\x85\\xa9LfnW\\xe4v\\x9d\\x08x\\xca\\x96r\\x07\\x9e\\xc96\\xb8\\x0b\\x98\\xdc',"
   "                    's2ma\\x00\\x00EU\\x7fAA\\x1a\\xa5\\x97\\xf4\\xb4d@\\xd4*V3H\\xbfS\\x82-*h\\x11/\\x01\\x04\\xf9\\xb8\\x91\\xf6\\xf0Z\\xe1',"
   "                    's2ma\\x00\\x00EU\\x13\\x93\\xcf\\x01\\xd5}\\xf6\\x14-m\\xd9cV\\x0b\\t\\xaf?\\xb4\\xe4\\xef\\xe2\\x1c\\x01\\xd3\\xc9\\xa3l\\x11\\xd01\\xd12'],"
   " 'm_campaignIndex': 0,"
   " 'm_defaultDifficulty': 3,"
   " 'm_description': '',"
   " 'm_difficulty': '',"
   " 'm_gameSpeed': 4,"
   " 'm_imageFilePath': '',"
   " 'm_isBlizzardMap': True,"
   " 'm_mapFileName': '',"
   " 'm_miniSave': False,"
   " 'm_modPaths': None,"
   " 'm_playerList': [{'m_color': {'m_a': 255, 'm_b': 30, 'm_g': 20, 'm_r': 180},"
   "                   'm_control': 2,"
   "                   'm_handicap': 100,"
   "                   'm_hero': '',"
   "                   'm_name': '[Lowko]<sp/>Lowko',"
   "                   'm_observe': 0,"
   "                   'm_race': 'Zerg',"
   "                   'm_result': 1,"
   "                   'm_teamId': 0,"
   "                   'm_toon': {'m_id': 227898,"
   "                              'm_programId': '\\x00\\x00S2',"
   "                              'm_realm': 1,"
   "                              'm_region': 2},"
   "                   'm_workingSetSlotId': 0},"
   "                  {'m_color': {'m_a': 255, 'm_b': 255, 'm_g': 66, 'm_r': 0},"
   "                   'm_control': 2,"
   "                   'm_handicap': 100,"
   "                   'm_hero': '',"
   "                   'm_name': '[ParaSC]<sp/>Gaofushuai',"
   "                   'm_observe': 0,"
   "                   'm_race': 'Protoss',"
   "                   'm_result': 2,"
   "                   'm_teamId': 1,"
   "                   'm_toon': {'m_id': 3207048,"
   "                              'm_programId': '\\x00\\x00S2',"
   "                              'm_realm': 1,"
   "                              'm_region': 2},"
   "                   'm_workingSetSlotId': 1}],"
   " 'm_restartAsTransitionMap': False,"
   " 'm_thumbnail': {'m_file': 'Minimap.tga'},"
   " 'm_timeLocalOffset': 36000000000,"
   " 'm_timeUTC': 130918978219437678,"
   " 'm_title': 'Ulrena'}"])

(def example-json-details
  [{"m_cacheHandles"           ["s2ma"
                                "s2ma"
                                "s2max00x00EUft82x12x84Sxefxffxbbx|x80xb7xd3xeexc1xadx81xbdxe5x83xc90xdexa7x9cNPZx04"
                                "s2maxc5;@"
                                "s2max00x00EUWxb4xacx0b=xdaxd0Txbaxdfx85xa9LfnWxe4vx9dx08xxcax96rx07x9exc96xb8x0bx98xdc"
                                "s2max00x00EUx7fAAx1axa5x97xf4xb4d@xd4*V3HxbfSx82-*hx11/x01x04xf9xb8x91xf6xf0Zxe1"
                                "s2ma"],
    "m_difficulty"             "",
    "m_restartAsTransitionMap" false,
    "m_timeUTC"                130918978219437678,
    "m_description"            "",
    "m_mapFileName"            "",
    "m_imageFilePath"          "",
    "m_campaignIndex"          0,
    "m_gameSpeed"              4,
    "m_modPaths"               nil,
    "m_timeLocalOffset"        36000000000,
    "m_isBlizzardMap"          true,
    "m_title"                  "Ulrena",
    "m_miniSave"               false,
    "m_playerList"             [{"m_color"            {"m_a" 255,
                                                       "m_b" 30,
                                                       "m_g" 20,
                                                       "m_r" 180},
                                 "m_teamId"           0,
                                 "m_observe"          0,
                                 "m_result"           1,
                                 "m_hero"             "",
                                 "m_name"             "[Lowko]<sp/>Lowko",
                                 "m_race"             "Zerg",
                                 "m_control"          2,
                                 "m_handicap"         100,
                                 "m_workingSetSlotId" 0,
                                 "m_toon"             {"m_id"        227898,
                                                       "m_programId" "x00x00S2",
                                                       "m_realm"     1,
                                                       "m_region"    2}}
                                {"m_color"            {"m_a" 255,
                                                       "m_b" 255,
                                                       "m_g" 66,
                                                       "m_r" 0},
                                 "m_teamId"           1,
                                 "m_observe"          0,
                                 "m_result"           2,
                                 "m_hero"             "",
                                 "m_name"             "[ParaSC]<sp/>Gaofushuai",
                                 "m_race"             "Protoss",
                                 "m_control"          2,
                                 "m_handicap"         100,
                                 "m_workingSetSlotId" 1,
                                 "m_toon"             {"m_id"        3207048,
                                                       "m_programId" "x00x00S2",
                                                       "m_realm"     1,
                                                       "m_region"    2}}],
    "m_thumbnail"              {"m_file" "Minimap.tga"},
    "m_defaultDifficulty"      3}])

(def expected-players-details
  [{"m_race"     "Zerg",
    "m_name"     "[Lowko]<sp/>Lowko",
    "m_result"   1,
    "m_playerId" 1}
   {"m_race"     "Protoss",
    "m_name"     "[ParaSC]<sp/>Gaofushuai",
    "m_result"   2,
    "m_playerId" 2}])

(def example-trackerevents
  ["{'_bits': 304,"
   " '_event': 'NNet.Replay.Tracker.SUnitBornEvent',"
   " '_eventid': 1,"
   " '_gameloop': 10034,"
   " 'm_controlPlayerId': 1,"
   " 'm_unitTagIndex': 437,"
   " 'm_unitTagRecycle': 2,"
   " 'm_unitTypeName': 'Overlord',"
   " 'm_upkeepPlayerId': 1,"
   " 'm_x': 51,"
   " 'm_y': 29}"])

(def example-json-trackerevents
  [{"_gameloop" 10034, "m_controlPlayerId" 1, "m_upkeepPlayerId" 1, "m_y" 29, "_event" "NNet.Replay.Tracker.SUnitBornEvent", "m_unitTypeName" "Overlord", "m_x" 51, "m_unitTagIndex" 437, "_bits" 304, "m_unitTagRecycle" 2, "_eventid" 1}])

(def building-tracker
  ["{'_bits': 336,"
   " '_event': 'NNet.Replay.Tracker.SUnitInitEvent',"
   " '_eventid': 6,"
   " '_gameloop': 1769,"
   " 'm_controlPlayerId': 1,"
   " 'm_unitTagIndex': 238,"
   " 'm_unitTagRecycle': 1,"
   " 'm_unitTypeName': 'SpawningPool',"
   " 'm_upkeepPlayerId': 1,"
   " 'm_x': 24,"
   " 'm_y': 20}"
   "{'_bits': 120,"
   " '_event': 'NNet.Replay.Tracker.SUnitDoneEvent',"
   " '_eventid': 7,"
   " '_gameloop': 1786,"
   " 'm_unitTagIndex': 232,"
   " 'm_unitTagRecycle': 1}"
   "{'_bits': 280,"
   " '_event': 'NNet.Replay.Tracker.SUnitBornEvent',"
   " '_eventid': 1,"
   " '_gameloop': 1799,"
   " 'm_controlPlayerId': 1,"
   " 'm_unitTagIndex': 239,"
   " 'm_unitTagRecycle': 1,"
   " 'm_unitTypeName': 'Larva',"
   " 'm_upkeepPlayerId': 1,"
   " 'm_x': 21,"
   " 'm_y': 22}"
   "{'_bits': 280,"
   " '_event': 'NNet.Replay.Tracker.SUnitBornEvent',"
   " '_eventid': 1,"
   " '_gameloop': 1799,"
   " 'm_controlPlayerId': 1,"
   " 'm_unitTagIndex': 239,"
   " 'm_unitTagRecycle': 1,"
   " 'm_unitTypeName': 'Larva',"
   " 'm_upkeepPlayerId': 1,"
   " 'm_x': 21,"
   " 'm_y': 22}"])

(def expected-buildings
  [{"_gameloop" 1769, "m_controlPlayerId" 1, "m_upkeepPlayerId" 1, "m_y" 20, "_event" "NNet.Replay.Tracker.SUnitInitEvent", "m_unitTypeName" "SpawningPool", "m_x" 24, "m_unitTagIndex" 238, "_bits" 336, "m_unitTagRecycle" 1, "_eventid" 6}])

(def expected-te-groups
  [[[238 1] [{"_gameloop" 1769, "m_controlPlayerId" 1, "m_upkeepPlayerId" 1, "m_y" 20, "_event" "NNet.Replay.Tracker.SUnitInitEvent", "m_unitTypeName" "SpawningPool", "m_x" 24, "m_unitTagIndex" 238, "_bits" 336, "m_unitTagRecycle" 1, "_eventid" 6}]]
   [[232 1] [{"_bits" 120, "_event" "NNet.Replay.Tracker.SUnitDoneEvent", "_eventid" 7, "_gameloop" 1786, "m_unitTagIndex" 232, "m_unitTagRecycle" 1}]]
   [[239 1] [{"_gameloop" 1799, "m_controlPlayerId" 1, "m_upkeepPlayerId" 1, "m_y" 22, "_event" "NNet.Replay.Tracker.SUnitBornEvent", "m_unitTypeName" "Larva", "m_x" 21, "m_unitTagIndex" 239, "_bits" 280, "m_unitTagRecycle" 1, "_eventid" 1}
             {"_gameloop" 1799, "m_controlPlayerId" 1, "m_upkeepPlayerId" 1, "m_y" 22, "_event" "NNet.Replay.Tracker.SUnitBornEvent", "m_unitTypeName" "Larva", "m_x" 21, "m_unitTagIndex" 239, "_bits" 280, "m_unitTagRecycle" 1, "_eventid" 1}]]
   ])

(def expected-building-timing
  [{"_gameloop" 1769, "m_unitTypeName" "SpawningPool", "m_controlPlayerId" 1, "_event" "NNet.Replay.Tracker.SUnitInitEvent"}])

(def events-for-players
  {1 [{"_gameloop" 1769, "m_controlPlayerId" 1, "m_upkeepPlayerId" 1, "m_y" 20, "_event" "NNet.Replay.Tracker.SUnitInitEvent", "m_unitTypeName" "SpawningPool", "m_x" 24, "m_unitTagIndex" 238, "_bits" 336, "m_unitTagRecycle" 1, "_eventid" 6}
      {"_gameloop" 1799, "m_controlPlayerId" 1, "m_upkeepPlayerId" 1, "m_y" 22, "_event" "NNet.Replay.Tracker.SUnitBornEvent", "m_unitTypeName" "Larva", "m_x" 21, "m_unitTagIndex" 239, "_bits" 280, "m_unitTagRecycle" 1, "_eventid" 1}
      {"_gameloop" 1799, "m_controlPlayerId" 1, "m_upkeepPlayerId" 1, "m_y" 22, "_event" "NNet.Replay.Tracker.SUnitBornEvent", "m_unitTypeName" "Larva", "m_x" 21, "m_unitTagIndex" 239, "_bits" 280, "m_unitTagRecycle" 1, "_eventid" 1}]})