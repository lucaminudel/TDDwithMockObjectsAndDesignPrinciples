require 'test/unit'
require_relative './alarm'

class AlarmTest < Test::Unit::TestCase
  def test_do_something
    alarm = Alarm.new
    alarm.check
  end
end