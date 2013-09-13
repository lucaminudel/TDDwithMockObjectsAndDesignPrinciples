require 'test/unit'
require_relative './telemetry_diagnostic_controls'

class TelemetryDiagnosticControlsTest < Test::Unit::TestCase

  def test_do_something
    ctrl = TelemetryDiagnosticControls.new

    ctrl.check_transmission
    ctrl.diagnostic_info
  end
end