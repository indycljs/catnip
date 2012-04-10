# This Source Code Form is subject to the terms of the Mozilla Public
# License, v. 2.0. If a copy of the MPL was not distributed with this file,
# You can obtain one at http://mozilla.org/MPL/2.0/.

define ["jquery", "ace/lib/event_emitter"
], ($, event_emitter) ->

  EventEmitter = event_emitter.EventEmitter

  class BufferMenu
    constructor: (@list, @repl) ->
      this[key] = EventEmitter[key] for own key of EventEmitter
      @attachToRepl(@repl) if @repl?
      @list.on("click", "li.item", @onClick)
      @updateList()

    attachToRepl: =>
      @repl.on("openBuffer", @updateList)

    updateList: =>
      @list.html("")
      @buffers = @repl.getBufferHistory()
      @nodes = @buffers.map (buffer) =>
        node = $("<li></li>").addClass("item").text(buffer)
        @list.append(node)
        node[0]
      @list.append($("<li></li>").addClass("divider"))
      openItem = $("<li></li>").addClass("item").text("Open...")
      @nodes.push(openItem)
      @list.append(openItem)

    onClick: (e) =>
      index = @nodes.indexOf(e.target)
      if index < 0
        @repl.selectFile()
      else
        @repl.loadBuffer(@buffers[index])
